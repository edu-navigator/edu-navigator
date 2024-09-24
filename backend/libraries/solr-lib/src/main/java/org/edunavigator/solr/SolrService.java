package org.edunavigator.solr;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.edunavigator.solr.api.SchoolSolrResponse;
import org.edunavigator.solr.api.SolrAddDocumentRequest;
import org.edunavigator.solr.utils.SolrResponseMapper;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;
public class SolrService {
    private HttpSolrClient solr;
    @Value("${solr.host}")
    private String solrHost;
    private final String QUERY_FIELD = "search_all";
    public SolrService(String solrHost){
        this.solrHost = solrHost;
        solr = new HttpSolrClient.Builder(solrHost).build();
    }
    public SolrService(){
        solr = new HttpSolrClient.Builder(solrHost).build();
    }
    public void addSolrDocument(SolrAddDocumentRequest request){
        try
        {
            solr.addBean(request.getRequestData());
            solr.commit();
        }catch (Exception ex)
        {
            throw new RuntimeException();
        }
    }
    public List<SchoolSolrResponse> Query(String text){
        try{
            SolrQuery query = new SolrQuery();
            String formattedQuery = String.format("%s:%s",QUERY_FIELD,text);
            query.set("q", formattedQuery);
            QueryResponse response = solr.query(query);
            return mapResults(response);
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }
    private List<SchoolSolrResponse> mapResults(QueryResponse queryResponse){
        List<SchoolSolrResponse> mapped = new ArrayList<>();
        for(SolrDocument solrDocument:queryResponse.getResults()){
            SchoolSolrResponse school = SolrResponseMapper.mapSchool(solrDocument);
            mapped.add(school);
        }
        return mapped;
    }
}
