package com.sapient.newfilter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.newfilter.news.FilteredNews;
import com.sapient.newfilter.service.IServiceFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(path = "/news")
public class NewsFilterController {

    @Autowired
    IServiceFilter serviceFilter;

    @GetMapping(path = "/filterNews")
    public Response getNews(@RequestParam @NotBlank String country, @RequestParam @NotBlank String category, @RequestParam  @NotBlank String keyword) throws Exception {

    	FilteredNews filteredNews = serviceFilter.getRelevantNews(country,category,keyword);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(filteredNews);
        return Response.ok().entity(filteredNews).build();
    }

}
