package com.sapient.newfilter.service;

import com.sapient.newfilter.news.FilteredNews;

public interface IServiceFilter {
	public FilteredNews getRelevantNews(String country, String category, String keyword);
}
