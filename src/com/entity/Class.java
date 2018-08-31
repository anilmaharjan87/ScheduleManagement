package com.entity;

/**
 * A simple class abstraction -- basically a container for class, group, module, professor, timeslot, and room IDs
 */
public class Class {
    private final int classId;
    private final int groupId;
    private final int subjectId;
    private int professorId;
    private int timeslotId;
    private int roomId;
    
    /**
     * Initialize new Class
     * 
     * @param classId
     * @param groupId
     * @param subjectId
     */
    public Class(int classId, int groupId, int subjectId){
        this.classId = classId;
        this.subjectId = subjectId;
        this.groupId = groupId;
    }
    
    /**
     * Add professor to class
     * 
     * @param professorId
     */
    public void addProfessor(int professorId){
        this.professorId = professorId;
    }
    
    /**
     * Add timeslot to class
     * 
     * @param timeslotId
     */
    public void addTimeslot(int timeslotId){
        this.timeslotId = timeslotId;
    }    
    
    /**
     * Add room to class
     * 
     * @param roomId
     */
    public void setRoomId(int roomId){
        this.roomId = roomId;
    }
    
    /**
     * Get classId
     * 
     * @return classId
     */
    public int getClassId(){
        return this.classId;
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
     * Get subjectId
     * 
     * @return subjectId
     */
    public int getSubjectId(){
        return this.subjectId;
    }
    
    /**
     * Get professorId
     * 
     * @return professorId
     */
    public int getProfessorId(){
        return this.professorId;
    }
    
    /**
     * Get timeslotId
     * 
     * @return timeslotId
     */
    public int getTimeslotId(){
        return this.timeslotId;
    }
    
    /**
     * Get roomId
     * 
     * @return roomId
     */
    public int getRoomId(){
        return this.roomId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", groupId=" + groupId +
                ", subjectId=" + subjectId +
                ", professorId=" + professorId +
                ", timeslotId=" + timeslotId +
                ", roomId=" + roomId +
                '}';
    }
}


