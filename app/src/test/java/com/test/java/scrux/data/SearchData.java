package com.test.java.scrux.data;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class SearchData {

    private String searchTerm;

    public String setSearchTerm(String searchTerm) {
        return this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

}
