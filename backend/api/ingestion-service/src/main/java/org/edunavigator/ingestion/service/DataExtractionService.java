package org.edunavigator.ingestion.service;
import org.edunavigator.core.School;
import org.edunavigator.core.SchoolHistory;
import org.edunavigator.ingestion.utils.ExcelReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

@Service
public class DataExtractionService {

    public boolean extractData(MultipartFile file){
        List<School> extractedData = ExcelReader.read(file);
        return true;
    }

    private void processData(List<School> extractedData){
        for(School school:extractedData){
            school.setSchoolUUID(UUID.randomUUID().toString());
            String schoolHistoryUUID = UUID.randomUUID().toString();
            SchoolHistory schoolHistory = new SchoolHistory(
                    schoolHistoryUUID,school.getSchoolUUID()
                    ,school.getDataYear(),
                    school.getNumberOfLearners()
                    ,school.getNumberOfTeachers());

            //update Solr
        }
    }
}
