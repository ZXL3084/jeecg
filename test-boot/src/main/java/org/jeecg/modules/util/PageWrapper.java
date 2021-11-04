package org.jeecg.modules.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;

public class PageWrapper<T> implements Serializable {

    private long pageNum = 1;
    private long pageSize = 10;
    private long totalSize = 0;
    private List<T> records = Collections.emptyList();

    public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public static <T> PageWrapper<T> build(long pageNum, long pageSize) {
        PageWrapper<T> wrapper = new PageWrapper<>();
        wrapper.setPageNum(pageNum);
        wrapper.setPageSize(pageSize);
        return wrapper;
    }

    public static <T> PageWrapper<T> build(IPage<?> page, List<T> records) {
        PageWrapper<T> wrapper = new PageWrapper<>();
        wrapper.setPageNum(page.getCurrent());
        wrapper.setPageSize(page.getSize());
        wrapper.setTotalSize(page.getTotal());
        wrapper.setRecords(records);
        return wrapper;
    }

    public static <T> PageWrapper<T> build(long pageNum, long pageSize, long totalSize, List<T> records) {
        PageWrapper<T> wrapper = new PageWrapper<>();
        wrapper.setPageNum(pageNum);
        wrapper.setPageSize(pageSize);
        wrapper.setTotalSize(totalSize);
        wrapper.setRecords(records);
        return wrapper;
    }

    public static <Req,Resp> PageWrapper<Resp> build(Page<Req> page,List<Resp> records) {
        PageWrapper<Resp> wrapper = new PageWrapper<>();
        wrapper.setPageNum(page.getPageNum());
        wrapper.setPageSize(page.getPageSize());
        wrapper.setTotalSize(page.getTotal());
        wrapper.setRecords(records);
        return wrapper;
    }

}
