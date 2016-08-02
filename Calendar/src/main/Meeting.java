package main;

import java.util.*;


public class Meeting {
	
	int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
    
    public static List<Meeting> condenseMeetingTimes(List<Meeting> meetings) {
//    	Collections.sort(meetings, new Comparator<Meeting>() {
//            public int compare(Meeting m1, Meeting m2)  {
//                return m1.startTime - m2.startTime;
//            }
//        });
//    	
//    	List<Meeting> merged = new ArrayList<Meeting>();
//    	merged.add(meetings.get(0));
//    	
//    	for(Meeting m: meetings) {
////    		Meeting m = meetings.get(i);
////    		Meeting next_m = null;
////    		
////    		if(i <= meetings.size() - 2) {
////    			next_m = meetings.get(i+1);
////    		
////    		
////	    		//Meeting merg = null;
////	    		
////	    		if(m.endTime >= next_m.startTime) {
////	    			Meeting merg = new Meeting(m.startTime, Math.max(m.endTime, next_m.endTime));
////	    		
////	    			merged.add(merg);
////	    		}
////    		}
////    		
////    		merged.add(m);
//    		Meeting lastMergedMeeting = meetings.get(meetings.size() - 1);
//    		
//    		if (m.startTime <= lastMergedMeeting.endTime) {
//                lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, m.endTime);
//
//            // add the current meeting since it doesn't overlap
//            } else {
//                merged.add(m);
//            }
//    	}
//    	
//    	
//    	return merged;
    	
    	// sort by start times
        List<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2)  {
                return m1.startTime - m2.startTime;
            }
        });

        // initialize mergedMeetings with the earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<Meeting>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (Meeting currentMeeting : sortedMeetings) {

            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // if the current and last meetings overlap, use the latest end time
            if (currentMeeting.startTime <= lastMergedMeeting.endTime) {
                lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);

            // add the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Meeting m1 = new Meeting(0,1);
		Meeting m2 = new Meeting(3,5);
		Meeting m3 = new Meeting(4,8);
		Meeting m4 = new Meeting(10,12);
		Meeting m5 = new Meeting(9,10);
		
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(m1);
		meetings.add(m2);
		meetings.add(m3);
		meetings.add(m4);
		meetings.add(m5);
		
		List<Meeting> condensedMeetings = Meeting.condenseMeetingTimes(meetings);
		
		for(int i = 0; i < condensedMeetings.size(); i++) {
			Meeting m = condensedMeetings.get(i);
			System.out.print(m.toString());
		}

	}

}
