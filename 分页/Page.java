package com.system.util.page;

import java.util.List;

import com.system.util.sort.Sort;

/**
 * 分页类
 * 
 * @author 王嘉明
 * @createTime:2013/11/18
 * @param <T>
 */
public class Page<T> {
	private String forwordName;// 跳转路径
	private int pageNo = 1;// 页数,默认一页
	private int pageSize = 1;// 每页显示记录数
	private long totalCount = -1;// 记录总数
	private List<T> result;// 取得页内的记录列表
	private String sort="desc";// 设置排序跳转

	/**
	 * 有参构造参数
	 * @param pageSize 每页显示数量
	 * @param forwordName 分页路径
	 * @param sort 排序
	 */
	public Page(int pageSize,String forwordName,String sort) {
		this.pageSize = pageSize;
		this.forwordName=forwordName;
		this.sort=sort;
	}

	/**
	 * 获取下页页号，序号从1开始，若为尾页，返回尾页页号
	 * 
	 * @return
	 */
	public int getNextPage() {
		if (isHasNext()) {// 若存在下一页
			return pageNo + 1;
		} else {
			return pageNo;
		}
	}

	/**
	 * 判断是否存在下一页
	 * 
	 * @return
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getTotalPages());// 判断页数+1是否超出最大页数
	}

	/**
	 * 获取总页数,默认为-1
	 * 
	 * @return
	 */
	public long getTotalPages() {
		if (totalCount < 0) {// 判断记录数
			return -1;
		}
		long count = totalCount / pageSize;// 分页总数
		if (totalCount % pageSize > 0) {// 求模，若>0 +1
			count++;
		}
		return count;
	}

	/**
	 * 取得上页页号，序号从1开始，若为首页，返回首页序号
	 * 
	 * @return
	 */
	public int getPrePage() {
		if (isHasPre()) {
			return pageNo - 1;
		} else {
			return pageNo;
		}
	}

	/**
	 * 是否有上一页
	 * 
	 * @return
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	public Page<T> pageNo(final int thePageNo) {
		setPageNo(thePageNo);
		return this;
	}

	public Page<T> pageSize(final int thePageSize) {
		setPageSize(thePageSize);
		return this;
	}

	// ----------get/set方法----------

	public String getForwordName() {
		int i = forwordName.indexOf("?");
		if (i < 0) {
			return forwordName + "?&sort="+sort+"&pageNo=";
		} else {
			return forwordName + "&sort="+sort+"&pageNo=";
		}
	}

	public void setForwordName(String forwordName) {
		this.forwordName = forwordName;
	}

	/**
	 * 获取当前页号，若序号大于总数，则当前页定位总页数
	 * 
	 * @return
	 */
	public int getPageNo() {
		if (this.getTotalPages() > -1 && this.pageNo > this.getTotalPages()) {
			this.pageNo = (int) this.getTotalPages();
		}
		return pageNo;
	}

	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;
		if (pageNo < 1) {// 若页数<1自动默认1
			this.pageNo = 1;
		}
	}

	/**
	 * 获取每页记录数，默认为1
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置记录数，若记录数<1，默认为1
	 * 
	 * @param pageSize
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < 1) {
			this.pageSize = 1;
		}
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * 获取分页标签
	 * 
	 * @return
	 */
	public String getTag() {
		StringBuffer pageTag = new StringBuffer();
		pageTag.append("<a href='" + getForwordName() + 1+ "&page=true' title='First Page'>&laquo; 首页</a>");
		pageTag.append("<a href='" + getForwordName() + getPrePage()+ "&page=true'title='Previous Page'>&laquo; 上一页</a>&nbsp;");
		pageTag.append("<a href='javascript:void(0);' class='number current' title='当前在第"+ getPageNo() + "页'>第" + getPageNo() + "页</a>&nbsp;");
		pageTag.append("<a href='" + getForwordName() + getNextPage() +"&page=true'title='Previous Page'>下一页  &raquo;</a>&nbsp;");
		pageTag.append("<a href='" + getForwordName() + getTotalPages()	+ "&page=true'title='Previous Page'>尾页  &raquo;</a>&nbsp;");
		pageTag.append("记录数总数" + getTotalCount() + "条;共" + getTotalPages()+ "页");
		return pageTag.toString();
	}

	/**
	 * 排序超链接
	 * 
	 * @return
	 */
	public String getSort() {
		String[] sortURL = getForwordName().split("sort=desc");//判断路径是否有该排序
		if (sortURL.length < 2) {
			sortURL= getForwordName().split("sort=asc");//若没有对这进行判断
		}
		StringBuffer url = new StringBuffer();//重写路径
		url.append(sortURL[0]);
		url.append("sort=" + Sort.sort(sort)+"&page=false");
		url.append(sortURL[1]+getPageNo());
		return url.toString();
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
