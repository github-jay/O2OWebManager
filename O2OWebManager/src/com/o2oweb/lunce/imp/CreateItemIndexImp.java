package com.o2oweb.lunce.imp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.ItemattributeDao;
import com.o2oweb.entity.Item;
import com.o2oweb.entity.Itemattribute;
import com.o2oweb.lunce.CreateIndex;


@Component("CreateIndex")
public class CreateItemIndexImp extends HibernateEntityDao<Item> implements CreateIndex{

	private static String IndexPath = "Index";
	private static String AnalysisPath = "Analysis";
	private SmartChineseAnalyzer analyzer;
	private Directory directory;
	private IndexWriterConfig config;
	private IndexWriter  writer;
	
	private HanyuPinyinOutputFormat format;
	
	@Autowired
	private ItemattributeDao itemattributeDao;
	public CreateItemIndexImp() throws Exception{
		analyzer = new SmartChineseAnalyzer(Version.LUCENE_47);
		directory = FSDirectory.open(new File(IndexPath));
		format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		
	}
	
	
	public void CreateOrAppent() throws Exception {
		// TODO Auto-generated method stub
		config = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		config.setOpenMode(OpenMode.CREATE_OR_APPEND);
		writer = new IndexWriter(directory, config);
		createIndex(writer);
	}

	
	
	public void reCreate() throws Exception {
		// TODO Auto-generated method stub
		config = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		config.setOpenMode(OpenMode.CREATE);
		writer = new IndexWriter(directory, config);
		createIndex(writer);
	}
	
	
	/**
	 * 实现创建索引的方法
	 * @param writer
	 * @throws Exception
	 */
	public void createIndex(IndexWriter writer) throws Exception{
		int start = 0;
		int limte = 100;
		DetachedCriteria detachecriteria = DetachedCriteria.forClass(entityClass);
		Page page = super.pagedQuery(detachecriteria, start, limte);
		long pageNum = page.getTotalPageCount();
		System.out.println(pageNum);
		for(int i=0;i<pageNum;i++){
			List<Item> dates =  (List<Item>) page.getData();
			for(Item item:dates){
				Document document = new Document();
				document.add(new TextField("id", item.getItemId().toString(),Store.YES));
				
				System.out.println("dddddddddddddddddddddddddddddddddddddd：" + item.getItemId());
				document.add(new TextField("name", item.getItemName(), Store.YES));
				String namepinyin = toPinyin(item.getItemName());		
				document.add(new TextField("pinyinname",namepinyin,Store.YES));
				List<Itemattribute> attributes = itemattributeDao.getAttributes(item.getItemId());
				StringBuffer buffer = new StringBuffer();
				for(Itemattribute attribute:attributes){
					buffer.append(attribute.getAttributeDetail());
				}
				document.add(new TextField("attribute", buffer.toString(), Store.YES));
				writer.addDocument(document);
//				start += limte;
//				DetachedCriteria detache = DetachedCriteria.forClass(entityClass);
//				page = super.pagedQuery(detache, start, limte);
			}
			start += limte;
			DetachedCriteria detache = DetachedCriteria.forClass(entityClass);
			page = super.pagedQuery(detache, start, limte);
		}
		writer.close();
	}
	public String toPinyin(String name) throws BadHanyuPinyinOutputFormatCombination{
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<name.length();i++){
			char sub = name.charAt(i);
			String[] subPinyin = PinyinHelper.toHanyuPinyinStringArray(sub, format);
			if (subPinyin != null) {
//				for (String pinyin : subPinyin) {
//					buffer.append(pinyin);
//				}
				buffer.append(subPinyin[0]);
			} else {
				buffer.append(sub);
			}
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}
}
