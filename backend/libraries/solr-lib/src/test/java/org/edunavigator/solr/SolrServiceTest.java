package org.edunavigator.solr;
import org.apache.solr.common.SolrDocumentList;
import org.edunavigator.solr.api.SchoolSolrResponse;
import org.edunavigator.solr.api.SolrAddDocumentRequest;
import org.edunavigator.solr.enums.DocType;
import org.edunavigator.solr.model.SchoolSolrBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolrServiceTest {
    private SolrService solrService;
    private SchoolSolrBean school;
    private SolrAddDocumentRequest solrAddDocumentRequest;
    @BeforeEach
    public void Setup(){
//         school = new SchoolSolrBean.Builder()
//                .setSchoolUUID("abc123-uuid-456xyz")
//                .setNatEmis("123456789")
//                .setInstitutionName("Springfield High School")
//                .setProvince("Gauteng")
//                .setStatus("Active")
//                .setSector("Public")
//                .setTypeOfDoe("Department of Education")
//                .setPhase("Secondary")
//                .setSpecialisation("Math and Science")
//                .setDistrict("Johannesburg East")
//                .setExamCentre("JHB-EXM-001")
//                .setStreetAddress("123 Main St, Springfield")
//                .setNoFeeSchool(true)
//                .setAreaType("Urban")
//                .build();
         school = new SchoolSolrBean.Builder()
                .setSchoolUUID("xyz987-uuid-654abc")
                .setNatEmis("987654321")
                .setInstitutionName("Lakeside Primary School")
                .setProvince("Western Cape")
                .setStatus("Active")
                .setSector("Private")
                .setTypeOfDoe("Independent")
                .setPhase("Primary")
                .setSpecialisation("General Education")
                .setDistrict("Cape Town Central")
                .setExamCentre("CTN-EXM-002")
                .setStreetAddress("456 Lakeview Rd, Lakeside")
                .setNoFeeSchool(false)
                .setAreaType("Suburban")
                .build();
         solrService = new SolrService("http://localhost:8983/solr/schools");
         solrAddDocumentRequest = new SolrAddDocumentRequest(DocType.SCHOOL_INFO,school);
    }

//    @Test
    public void addSolrDocument(){
        solrService.addSolrDocument(solrAddDocumentRequest);
    }
    @Test
    public void queryDocument(){
        String text = "Lakeside Primary ";
        List<SchoolSolrResponse> docs =  solrService.Query(text);
        assertEquals(1, docs.size());
    }
}