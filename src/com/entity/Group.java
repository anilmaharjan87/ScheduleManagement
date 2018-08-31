package com.entity;

/**
 * A simple "group-of-students" abstraction. Defines the modules that the group is enrolled in.
 *
 */
public class Group {
    private final int groupId;
    private final int groupSize;
    private final int subjectIds[];

    /**
     * Initialize Group
     * 
     * @param groupId
     * @param groupSize
     * @param subjectIds
     */
    public Group(int groupId, int groupSize, int subjectIds[]){
        this.groupId = groupId;
        this.groupSize = groupSize;
        this.subjectIds = subjectIds;
    }
    
    /**
     * Get groupId
     * 
     * @return groupId
     */
    public int getGroupId(){
        return this.groupId;
    }
    
    /**
     * Get groupSize
     * 
     * @return groupSize
     */
    public int getGroupSize(){
        return this.groupSize;
    }
        
    /**
     * Get array of group's subjectIds
     * 
     * @return subjectIds
     */
    public int[] getSubjectIds(){
        return this.subjectIds;
    }
}
