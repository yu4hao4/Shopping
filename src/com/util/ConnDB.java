package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnDB {
	// 全局对象
	// 连接池
	public static ComboPooledDataSource cpds = new ComboPooledDataSource();
}
