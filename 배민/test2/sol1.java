// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.Comparator; 
import java.util.stream.*; 
import java.util.List;


class Solution {
    private class Photo {
    	public String filename, extension, city; 
    	public LocalDateTime time; 

    	public Photo(String filename, String extension, String city, LocalDateTime time) {
    		this.filename = filename; 
    		this.extension = extension;
    		this.city = city; 
    		this.time = time; 
    	} 

    	public String getCity() {return this.city;}
    	public LocalDateTime getTime() {return this.time;}
    }

    public String solution(String S) {
    	HashMap<String, Integer> countMap = new HashMap<>(); 
    	HashMap<String, Integer> maxDigitMap = new HashMap<>(); 
    	ArrayList<Photo> photoList = new ArrayList<>(); 

    	for(String line : S.split("\n")) {
    		String[] infos = line.split(", "); 
    		String[] fileInfos = infos[0].split("[.]");

    		String filename = fileInfos[0];
    		String extension = fileInfos[1];
    		String city = infos[1];
  			LocalDateTime time = LocalDateTime.parse(infos[2], 
  			                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    		photoList.add(new Photo(filename, extension, city, time)); 

    		if(countMap.containsKey(city)) {
    			Integer newValue = countMap.get(city) + 1;
				if(newValue == 10) {
					newValue = 0; 
					maxDigitMap.put(city, maxDigitMap.get(city) + 1);
				}
    			countMap.put(city, newValue);
    		} else { 
    			countMap.put(city, 1); 
    			maxDigitMap.put(city, 1);
    		}
    	}

    	Comparator<Photo> byCity = (p1, p2) -> (p1.getCity()).compareTo(p2.getCity());
    	Comparator<Photo> byTime = (p1, p2) -> (p1.getTime()).compareTo(p2.getTime());

    	List<Photo> sortedPhotoList = photoList.stream().sorted(byCity.thenComparing(byTime)).collect(Collectors.toList()); 

    	HashMap<String, String> nameMap = new HashMap<>(); 

    	int index = 1;
    	String prev = "", myFormat = ""; 
    	for(Photo photo : sortedPhotoList) {
    		if(!photo.city.equals(prev)) {
    			index = 1; 
    			myFormat = "%0" + maxDigitMap.get(photo.city) + "d";
    		}
    		String photoNumber = String.format(myFormat, index++);
    		nameMap.put(photo.filename + "." + photo.extension, photo.city + photoNumber + "." + photo.extension);
    		prev = photo.city;
    	}

    	List<String> newNameList = new ArrayList<>(); 

    	for(Photo photo : photoList) {
    		newNameList.add(nameMap.get(photo.filename + "." + photo.extension));
    	}

    	return String.join("\n", newNameList);
    }
}    