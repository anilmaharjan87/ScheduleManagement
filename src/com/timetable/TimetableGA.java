package com.timetable;

import com.connection.DBConnection;
import com.entity.Class;

import java.sql.*;


public class TimetableGA {

	public static void main(String[] args) throws SQLException {
		init();
	}
	
    public static void  init () throws SQLException {
    	// Get a Timetable object with all the available information.
        Timetable timetable = initializeTimetable();

        // Initialize GA
        GeneticAlgorithm ga = new GeneticAlgorithm(1000, 0.001, 0.99, 5, 10);

        // Initialize population
        Population population = ga.initPopulation(timetable);

        // Evaluate population
        ga.evalPopulation(population, timetable);

        // Keep track of current generation
        int generation = 1;

        // Start evolution loop
        while (ga.isTerminationConditionMet(generation, 100) == false
            && ga.isTerminationConditionMet(population) == false) {
            // Print fitness
            System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, timetable);

            // Evaluate population
            ga.evalPopulation(population, timetable);

            // Increment the current generation
            generation++;
        }

        // Print fitness
        timetable.createClasses(population.getFittest(0));
        System.out.println();
        System.out.println("Solution found in " + generation + " generations");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        System.out.println("Clashes: " + timetable.calcClashes());

        // Print classes
        Connection connection= DBConnection.openConnection();
        PreparedStatement pst= connection.prepareStatement("insert into class (class_id,group_id,subject_id,professor_id,room_id,timeslot_id) values (?,?,?,?,?,?)");
        Class classes[] = timetable.getClasses();
        int classIndex = 1;

        for (Class bestClass : classes) {
            // saving class in database
            pst.setInt(1,classIndex);
            pst.setInt(2,bestClass.getGroupId());
            pst.setInt(3,bestClass.getSubjectId());
            pst.setInt(4,bestClass.getProfessorId());
            pst.setInt(5,bestClass.getRoomId());
            pst.setInt(6,bestClass.getTimeslotId());
            pst.execute();


            System.out.println("Class " + classIndex + ":");
            System.out.println("Subject: " +
                    timetable.getModule(bestClass.getSubjectId()).getSubjectName());
            System.out.println("Group: " +
                    timetable.getGroup(bestClass.getGroupId()).getGroupId());
            System.out.println("Room: " +
                    timetable.getRoom(bestClass.getRoomId()).getRoomNumber());
            System.out.println("Professor: " +
                    timetable.getProfessor(bestClass.getProfessorId()).getProfessorName());
            System.out.println("Time: " +
                    timetable.getTimeslot(bestClass.getTimeslotId()).getTimeslot());
            System.out.println("-----");
            classIndex++;

        }
    }

    /**
     * Creates a Timetable with all the necessary course information.
     *
     * Normally you'd get this info from a database.
     *
     * @return
     */

	private static Timetable initializeTimetable() {
        // Create com.timetable
        Timetable timetable = new Timetable();
        try {
            Connection con=DBConnection.openConnection();
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();
            ResultSet subjects=null;


            ResultSet rooms = stmt.executeQuery("select * from room");
            // Set up rooms
            while (rooms.next()) {
                timetable.addRoom(rooms.getInt(1), rooms.getString(2), rooms.getInt(3));
            }

            // Set up timeslots
            ResultSet timeslots = stmt.executeQuery("select * from timeslot");
            while (timeslots.next()) {
                timetable.addTimeslot(timeslots.getInt(1), timeslots.getString(2));
            }

            // Set up professors
            ResultSet professors = stmt.executeQuery("select * from professor");
            while (professors.next()) {
                timetable.addProfessor(professors.getInt(1), professors.getString(2));
            }


            // Set up modules and define the professors that teach them
            subjects = stmt.executeQuery("select * from subject");
            while (subjects.next()) {
                ResultSet professors1 = stmt1.executeQuery("select * from subject_professor where subject_id=" + subjects.getInt(1));

                int rowcount = 0;
                if (professors1.last()) {
                    rowcount = professors1.getRow();
                    professors1.beforeFirst();
                }
                int[] profs = new int[rowcount];
                int count = 0;
                while (professors1.next()) {
                    profs[count++] = professors1.getInt(2);
                }
                timetable.addSubject(subjects.getInt(1),subjects.getString(2),subjects.getString(3),profs);
            }




                // Set up student groups and the modules they take.
                ResultSet st_gr = stmt.executeQuery("select * from student_group");
            int subject_count = 0;
                while(st_gr.next()){
                    ResultSet mods = stmt1.executeQuery("select subject_id from subject where group_id="+st_gr.getInt("group_id"));
                    int rowcount1=0;
                    if(mods.last()){
                        rowcount1 = mods.getRow();
                        mods.beforeFirst();
                    }
                    int [] mod1 = new int[rowcount1];
                    int count1=0;
                    while(mods.next()){
                        mod1[count1++]=mods.getInt("subject_id");
                    }
                    timetable.addGroup(st_gr.getInt("group_id"),st_gr.getInt("group_size"),mod1);

                }

                con.close();
                return timetable;
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

}