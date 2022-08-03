package icu.aierx.boot.model;

import lombok.Data;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@Data
public class PageVO {
	int pageSize;
	int curPage;
	Long totalSize;
	
	public PageVO(int curPage, int pageSize) {
		this.pageSize = pageSize;
		this.curPage = curPage;
	}
}
