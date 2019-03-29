package com.eileen.data.apimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiSearch {

    @JsonProperty("Search")
    private List<ApiMovie> search = new ArrayList<>();
    private Integer totalResults;

    public ApiSearch() {

    }

    public void setSearch(List<ApiMovie> search) {
        this.search = search;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "ApiSearch{" +
                "search=" + search +
                ", totalResults=" + totalResults +
                '}';
    }
}
