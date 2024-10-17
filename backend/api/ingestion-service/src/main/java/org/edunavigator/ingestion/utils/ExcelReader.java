package org.edunavigator.ingestion.utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.edunavigator.core.School;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ExcelReader {

    public static List<School>  read(MultipartFile excelFile){
        List<School> schools = new ArrayList<>();

        try(InputStream inputStream = excelFile.getInputStream())
        {
            Workbook workbook = new SXSSFWorkbook(new XSSFWorkbook(inputStream));
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row:sheet){

                String nationalEmisNumber = getCellValue(row.getCell(IndexMapper.NATIONAL_EMIS_NUMBER));
                String dataYear = getCellValue(row.getCell(IndexMapper.DATA_YEAR));
                String province = getCellValue(row.getCell(IndexMapper.PROVINCE));
                String institutionName = getCellValue(row.getCell(IndexMapper.INSTITUTION_NAME));
                String status = getCellValue(row.getCell(IndexMapper.STATUS));
                String sector = getCellValue(row.getCell(IndexMapper.SECTOR));
                String typeOfDoe = getCellValue(row.getCell(IndexMapper.TYPE_OF_DOE));
                String phase = getCellValue(row.getCell(IndexMapper.PHASE));
                String specialisation = getCellValue(row.getCell(IndexMapper.SPECIALISATION));
                String district = getCellValue(row.getCell(IndexMapper.DISTRICT));
                String landOwner = getCellValue(row.getCell(IndexMapper.LAND_OWNER));
                String extendedDepartment = getCellValue(row.getCell(IndexMapper.EXTENDED_DEPARTMENT));
                String examCentre = getCellValue(row.getCell(IndexMapper.EXAM_CENTRE));
                String gisLongitude = getCellValue(row.getCell(IndexMapper.GIS_LONGITUDE));
                String gisLatitude = getCellValue(row.getCell(IndexMapper.GIS_LATITUDE));
                String districtMunName = getCellValue(row.getCell(IndexMapper.DISTRICT_MUN_NAME));
                String streetAddress = getCellValue(row.getCell(IndexMapper.STREET_ADDRESS));
                String postalAddress = getCellValue(row.getCell(IndexMapper.POSTAL_ADDRESS));
                String telephone = getCellValue(row.getCell(IndexMapper.TELEPHONE));
                String quintile = getCellValue(row.getCell(IndexMapper.QUINTILE));
                String registrationDate = getCellValue(row.getCell(IndexMapper.REGISTRATION_DATE));
                String noFeeSchool = getCellValue(row.getCell(IndexMapper.NO_FEE_SCHOOL));
                String areaType = getCellValue(row.getCell(IndexMapper.AREA_TYPE));
                String numberOfLearners = getCellValue(row.getCell(IndexMapper.NUMBER_OF_LEARNERS));
                String numberOfTeachers = getCellValue(row.getCell(IndexMapper.NUMBER_OF_TEACHERS));

                School school = new School();
                school.setNationalEmisNumber(nationalEmisNumber);
                school.setDataYear(dataYear);
                school.setProvince(province);
                school.setInstitutionName(institutionName);
                school.setStatus(status);
                school.setSector(sector);
                school.setTypeOfDoe(typeOfDoe);
                school.setPhase(phase);
                school.setSpecialisation(specialisation);
                school.setDistrict(district);
                school.setLandOwner(landOwner);
                school.setExtendedDepartment(extendedDepartment);
                school.setExamCentre(examCentre);
                school.setGisLongitude(Double.parseDouble(gisLongitude));
                school.setGisLatitude(Double.parseDouble(gisLatitude));
                school.setDistrictMunName(districtMunName);
                school.setStreetAddress(streetAddress);
                school.setPostalAddress(postalAddress);
                school.setTelephone(telephone);
                school.setQuintile(quintile);
                school.setRegistrationDate(LocalDate.parse(registrationDate)); // Ensure proper date parsing
                school.setNoFeeSchool(Boolean.parseBoolean(noFeeSchool));
                school.setAreaType(areaType);
                school.setNumberOfLearners(Integer.parseInt(numberOfLearners));
                school.setNumberOfTeachers(Integer.parseInt(numberOfTeachers));
                schools.add(school);
            }
            return schools;
        }catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
