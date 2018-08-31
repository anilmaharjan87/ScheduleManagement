package com.entity;

/**
 * Simple course subjectName abstraction, which defines the Professors teaching the subjectName.
 */
public class Subject {
    private final int subjectId;
    private final String subjectCode;
    private final String subjectName;
    private final int professorIds[];
    
    /**
     * Initialize new Subject
     * 
     * @param subjectId
     * @param subjectCode
     * @param subjectName
     * @param professorIds
     */
    public Subject(int subjectId, String subjectCode, String subjectName, int professorIds[]){
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.professorIds = professorIds;
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
     * Get subjectName code
     * 
     * @return subjectCode
     */
    public String getSubjectCode(){
        return this.subjectCode;
    }
    
    /**
     * Get subjectName name
     * 
     * @return subjectName
     */
    public String getSubjectName(){
        return this.subjectName;
    }
    
    /**
     * Get random professor Id
     * 
     * @return professorId
     */
    public int getRandomProfessorId(){
    	int index=(int) (professorIds.length * Math.random());
    	System.out.println("profesor:"+ index);
        int professorId = professorIds[index];
        return professorId;
    }
}
