package duplicateReportRemover;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DuplicateReportRemover {
	
	//List of Columns from the table
	static List<String> collist = Arrays.asList("iv_org_key", "iv_emp_no", "iv_all_level","iv_start_date", "iv_end_date",
			"iv_primary_project","iv_struct_code ", "iv_group_level1", "iv_group_level2", "iv_group_level3", "iv_group_level4", "iv_group_level5","is_deleted");
	
	//ColumnType
	static List<String> colTypelist = Arrays.asList("str", "int", "data", "date", "str",
			"str","str ", "str", "str", "str", "str", "str");
	
	//Columns need to be Skipped
	static List<String> excludedForComparesion = Arrays.asList("iv_start_date", "iv_end_date");
	
	//Final records need to be inserted
	static List<Map<String,Object>> primaryRecordsNeedToBeinserted = new ArrayList<>(); 
	
	//Secondary records need to be inserted
	static List<Map<String,Object>> secondaryRecordsNeedToBeinserted = new ArrayList<>();
	
	//Records need to be deleted
	static List<Map<String,Object>> recordsNeedToBeDeleted = new ArrayList<>();
	
	
	//Sample DB data
	public static List<Map<String, Object>> getData(){
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,11,30));
		dataMap.put("iv_end_date", LocalDate.of(2019,12,30));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", true);
		dataMap.put("iv_struct_code", "test2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", null);
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,12,31));
		dataMap.put("iv_end_date", LocalDate.of(2382,12,31));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", true);
		dataMap.put("iv_struct_code", "test2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", null);
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,1,1));
		dataMap.put("iv_end_date", LocalDate.of(2019,11,29));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", true);
		dataMap.put("iv_struct_code", "test2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", "null");
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,1,1));
		dataMap.put("iv_end_date", LocalDate.of(2019,11,29));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", true);
		dataMap.put("iv_struct_code", "test2-2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", "test5");
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(2));
		dataMap.put("iv_start_date", LocalDate.of(2019,1,1));
		dataMap.put("iv_end_date", LocalDate.of(2019,11,29));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", true);
		dataMap.put("iv_struct_code", "test2-2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", "test5");
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,11,30));
		dataMap.put("iv_end_date", LocalDate.of(2019,12,30));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", false);
		dataMap.put("iv_struct_code", "test2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", null);
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,12,31));
		dataMap.put("iv_end_date", LocalDate.of(2382,12,31));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", false);
		dataMap.put("iv_struct_code", "test2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", null);
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,1,1));
		dataMap.put("iv_end_date", LocalDate.of(2019,11,29));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", false);
		dataMap.put("iv_struct_code", "test2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", "null");
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		dataMap = new HashMap<>();
		dataMap.put("iv_org_key", "ivtl");
		dataMap.put("iv_emp_no", Integer.valueOf(1));
		dataMap.put("iv_start_date", LocalDate.of(2019,1,1));
		dataMap.put("iv_end_date", LocalDate.of(2019,11,29));
		dataMap.put("iv_all_level", "ivtl");
		dataMap.put("iv_primary_project", false);
		dataMap.put("iv_struct_code", "test2-2");
		dataMap.put("iv_group_level1", "test1");
		dataMap.put("iv_group_level2", "test2");
		dataMap.put("iv_group_level3", "test3");
		dataMap.put("iv_group_level4", "test4");
		dataMap.put("iv_group_level5", "test5");
		dataMap.put("is_deleted", true);
		list.add(dataMap);
		return list;
	}
	
public static boolean findDuplicateRecord(List<String> previousRecordList, Map<String,Object> recordMap, AtomicInteger duplicateIndex, List<Object> endDateList) {
		
		Map<String,String>stringMap = new HashMap<>();
		stringMap.put("RecordString", "");
		
		//Making the record data as a single String
		collist.forEach(column->{
			String tempString = stringMap.get("RecordString");
			if(!excludedForComparesion.contains(column)) {
				tempString+=Objects.nonNull(recordMap.get(column))?recordMap.get(column).toString():"null";
				tempString+=",";
			}
				stringMap.put("RecordString",tempString);
		});
		
		String tempString = stringMap.get("RecordString");
		
		//Checking for initial record
		if(previousRecordList.size()==0) {
			endDateList.add(recordMap.get("iv_end_date"));
			previousRecordList.add(tempString);
			return false;
		}
		
		//Checking previous record data is equal to current record
		int index=previousRecordList.lastIndexOf(tempString);
		if(previousRecordList.contains(tempString)&&(LocalDate.parse(recordMap.get("iv_start_date").toString()).equals(LocalDate.parse(endDateList.get(index).toString()).plusDays(1)))) {
			duplicateIndex.set(index);
			endDateList.set(index,recordMap.get("iv_end_date"));
			return true; 
		}
		
		//Current Record not matches with previous Employee, previous Employee record is validated.
		//previousRecordList.clear();
		
		//Add new record as constrain for next record
		endDateList.add(recordMap.get("iv_end_date"));
		previousRecordList.add(tempString);
		return false;
	}
	
	
	public static void main(String args[]) {
		
		//Data From DB
		List<Map<String, Object>> list = getData();
		
		//Group the record based on Employee no
		Map<Integer, List<Map<String, Object>>> empGroupMap=list.parallelStream().map((data)->data).collect(Collectors.groupingBy(data->(Integer)data.get("iv_emp_no")));
		
		//Primary Project data 
		List<String> primarydataList = new ArrayList<>();
		
		//Primary Project data 
		List<Object> primarydataEndDateList = new ArrayList<>();
		
		//Secondary Project data 
		List<String> secondarydataList = new ArrayList<>();
		
		//Secondary Project data 
		List<Object> secondarydataEndDateList = new ArrayList<>();
		
		empGroupMap.keySet().forEach(key ->{
				//Sort the Employee records based on record start date.
				empGroupMap.get(key).sort((a,b)->{
					return ((LocalDate)a.get("iv_start_date")).compareTo((LocalDate)b.get("iv_start_date"));
				});
				
				AtomicInteger duplicateIndex = new AtomicInteger();
				empGroupMap.get(key).forEach(map->{
					if((boolean) map.get("iv_primary_project")&&findDuplicateRecord(primarydataList, map, duplicateIndex, primarydataEndDateList)) {// If primary project and Search for duplicate index
						primaryRecordsNeedToBeinserted.get(duplicateIndex.get()).put("iv_end_date",map.get("iv_end_date"));// update the end date of duplicate primary data
						recordsNeedToBeDeleted.add(map);
					}else if(!(boolean) map.get("iv_primary_project")&&findDuplicateRecord(secondarydataList, map, duplicateIndex, secondarydataEndDateList)) {// If secondary project and Search for duplicate index
						secondaryRecordsNeedToBeinserted.get(duplicateIndex.get()).put("iv_end_date",map.get("iv_end_date"));// update the end date of duplicate secondary data
						recordsNeedToBeDeleted.add(map);
					}else if(!(boolean) map.get("iv_primary_project"))//If secondary project add to secondary List
						secondaryRecordsNeedToBeinserted.add(map);
					else//If Primary project add to primary List
						primaryRecordsNeedToBeinserted.add(map);
					});
			}
		);
		
		//To DB upsert
		primaryRecordsNeedToBeinserted.addAll((secondaryRecordsNeedToBeinserted));
		System.out.println(primaryRecordsNeedToBeinserted.toString());
		
		//To DB delete
		System.out.println(recordsNeedToBeDeleted.toString());
	}
}
