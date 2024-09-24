package org.edunavigator.solr.utils;

import org.apache.solr.common.SolrDocument;
import org.edunavigator.solr.api.SchoolSolrResponse;

import java.util.ArrayList;

public class SolrResponseMapper {

    public  static SchoolSolrResponse mapSchool(SolrDocument solrDocument){
        SchoolSolrResponse school = new SchoolSolrResponse();
        school.setSchoolUUID((String)solrDocument.get(SchoolFields.SCHOOL_UUID));
        school.setNatEmis((String)solrDocument.get(SchoolFields.NAT_EMIS));
        school.setInstitutionName(extractTextGeneral((ArrayList<String>)solrDocument.get(SchoolFields.INSTITUTION_NAME)));
        school.setProvince((String)solrDocument.get(SchoolFields.PROVINCE));
        school.setStatus((String)solrDocument.get(SchoolFields.STATUS));
        school.setSector((String)solrDocument.get(SchoolFields.SECTOR));
        school.setTypeOfDoe((String)solrDocument.get(SchoolFields.TYPE_OF_DOE));
        school.setPhase((String)solrDocument.get(SchoolFields.PHASE));
        school.setSpecialisation((String)solrDocument.get(SchoolFields.SPECIALIZATION));
        school.setDistrict((String)solrDocument.get(SchoolFields.DISTRICT));
        school.setExamCentre((String)solrDocument.get(SchoolFields.EXAM_CENTRE));
        school.setStreetAddress(extractTextGeneral((ArrayList<String>)solrDocument.get(SchoolFields.STREET_ADDRESS)));
        school.setNoFeeSchool((boolean)solrDocument.get(SchoolFields.NO_FEE_SCHOOL));
        school.setAreaType((String)solrDocument.get(SchoolFields.AREA_TYPE));
        return school;
    }

    private static String extractTextGeneral(ArrayList<String> textArray){
        if (!textArray.isEmpty())
            return textArray.get(0);
        else
            return "";
    }

}
