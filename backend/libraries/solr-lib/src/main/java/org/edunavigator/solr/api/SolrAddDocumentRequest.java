package org.edunavigator.solr.api;
import org.edunavigator.solr.enums.DocType;
import org.edunavigator.solr.model.SchoolSolrBean;
public class SolrAddDocumentRequest {
    private DocType type;
    private SchoolSolrBean schoolData;

    public SolrAddDocumentRequest(DocType type, SchoolSolrBean requestData) {
        this.type = type;
        this.schoolData = requestData;
    }
    
    public DocType getType() {
        return type;
    }

    public void setType(DocType type) {
        this.type = type;
    }

    public SchoolSolrBean getRequestData() {
        return schoolData;
    }

    public void setRequestData(SchoolSolrBean requestData) {
        this.schoolData = requestData;
    }
}
