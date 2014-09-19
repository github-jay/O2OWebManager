package com.o2oweb.dao;

import com.o2oweb.entity.Index3ainfo;

public interface Index3ainfoDao {

	public void save(Index3ainfo image);
	public Index3ainfo getIndex3ainfo(Integer id);
	public void remove(Index3ainfo image);
	public void update(Index3ainfo image);
}
