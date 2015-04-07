package com.example.connext.connext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raahulbiswas on 15-03-30.
 */
public class SkillZz {
    private String id;
    private RealSkillZz skill;
    //private Map<String, RealSkillZz> skill = new HashMap<String, RealSkillZz>();
    SkillZz(){ }

    SkillZz(String realID, RealSkillZz skillzz){
        id = realID;
        skill = skillzz;
    }

    public RealSkillZz getSkill(){
        return skill;
    }

    public String getId(){
        return id;
    }

}
