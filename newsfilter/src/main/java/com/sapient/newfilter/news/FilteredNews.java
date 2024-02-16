package com.sapient.newfilter.news;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilteredNews {
	
	private Criteria criteria = new Criteria();
	private List<FilteredArticle> filteredArticles = new ArrayList<>(3);
}
