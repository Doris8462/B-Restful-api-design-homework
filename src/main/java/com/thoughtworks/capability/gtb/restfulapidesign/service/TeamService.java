package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.TeamNotExistException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {
    private Map<Integer, Team> teamMap = new HashMap<>();

    public TeamService() {
        teamMap.put( 1 ,new Team(1, "team1","",null));
        teamMap.put( 2 ,new Team(2, "team2","",null));
        teamMap.put( 3 ,new Team(3, "team3","",null));
        teamMap.put( 4 ,new Team(4, "team4","",null));
        teamMap.put( 5 ,new Team(5, "team5","",null));
        teamMap.put( 6 ,new Team(6, "team6","",null));
    }
    public List<Team> getAllTeams() {
            List<Student> students =StudentService.getStudentsByGender(null);
            Collections.shuffle(students);
            teamMap.forEach((index,team) ->{
                ArrayList<Student> teamStudents =new ArrayList<Student>();
                for (int i = 0; i < students.size(); i++) {
                    if((i % 6+1)==index) {
                        teamStudents.add(students.get(i));
                    }
                }
                team.setStudents(teamStudents);
            });
        return new ArrayList<>(teamMap.values());
    }

    public Team getTeamById(Integer id) {
        if(!teamMap.containsKey(id)) {
            throw new TeamNotExistException("小组不存在");
        }
        return teamMap.get(id);
    }

    public Team updateTeamById(Integer teamId,Team updateTeam){
        if(!teamMap.containsKey(teamId)) {
            throw new TeamNotExistException("小组不存在");
        }
        Team team=teamMap.get(teamId);
        team.setTeamName(updateTeam.getTeamName());
        team.setTeamNote(updateTeam.getTeamNote()==null?team.getTeamNote():updateTeam.getTeamNote());
        return team;
    }

}
