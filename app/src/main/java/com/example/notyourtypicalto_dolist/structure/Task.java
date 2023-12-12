package com.example.notyourtypicalto_dolist.structure;

import static com.example.notyourtypicalto_dolist.structure.Ai_prompt.prompt;

import java.sql.Time;
import java.util.List;

public class Task extends BaseTask {
    private String taskDescription;
    private Integer rewards_count;
    private Difficulty taskDifficultyOpinion;
    private List<BaseTask> subtasks;
    private Time deadLine;
    private String advice;

    public Task(String taskName, Difficulty taskDifficulty) {
        setTaskName(taskName);
        setTaskDifficultyOpinion(taskDifficulty);
        setRewards_count(0);
    }
    public Task(String taskName, String advice){
        super(taskName);
        this.advice = advice;
    }

    public Task() {

    }

    public Integer getRewards_count() {
        return rewards_count;
    }

    public void setRewards_count(Integer rewards) {
        if(taskDifficultyOpinion != null){
            String script = "I want you to tell me the difficulty of doing this task \""+taskName;
            if(!taskDescription.equals("")){
                script+= "\" which has the description of \""+taskDescription+"\".";
            }
            if(taskDifficultyOpinion == null){
                script+= " while the person thinking that the task is \"" +taskDifficultyOpinion+"\" between the options of [REALLY_EFFORTLESS, VERY_EASY, EASY, MEDIUM, HARD, VERY_HARD, REALLY_CHALLENGING].";
            }
            script+=" Don't say anything AT ALL other than the response of an integer number between 5-250 AND the standards being (examples): (\"5\" -> Drinking water, Sleeping while being sleepy.) \"250\" -> being the president, being an entrepreneur, starting a start-up.";

            try{
                if(taskDifficultyOpinion != null) {
                    rewards_count = Integer.parseInt(prompt(script));
                }
            }catch(Exception e) {
                switch (taskDifficultyOpinion) {
                    case REALLY_EFFORTLESS:
                        this.rewards_count = 5;
                        break;
                    case VERY_EASY:
                        this.rewards_count = 10;
                        break;
                    case EASY:
                        this.rewards_count = 20;
                        break;
                    case MEDIUM:
                        this.rewards_count = 40;
                        break;
                    case HARD:
                        this.rewards_count = 80;
                        break;
                    case VERY_HARD:
                        this.rewards_count = 160;
                        break;
                    case REALLY_CHALLENGING:
                        this.rewards_count = 320;
                        break;
                }
            }
        } else {
            rewards_count = rewards;
        }
    }

    public void AutoSubtask(){
        String script ="give me detailed numbered subtasks of how to do this task \"" +taskName+
                "\", which has the description of  \""+taskDescription+"\". " +
                "And at the end write a paragraph(ONLY) that has some advice on how to deal with this manner. " +
                "(do not use numbered points or bullet points in the advice part " +
                "AND before starting the advice paragraph write \"Advice:\"\n" +
                "notes: do not apologize for being an AI that can't do this.";
        String text = Ai_prompt.prompt(script);
        String parts[] = text.split("\\n\\n");
        this.advice = parts[parts.length];
        for (int i=1; i< parts.length-1; i++){
            String task[] = parts[i].split(":");
            String taskNm = task[0];
            String taskAdv = task[1].substring(1,task[1].length());
            subtasks.add(new Task(taskNm, taskAdv));
            advice = parts[parts.length];
        }
    }

    public void setTaskDifficultyOpinion(Difficulty taskDifficultyOpinion) {
        this.taskDifficultyOpinion = taskDifficultyOpinion;
    }

    public List<BaseTask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<BaseTask> subtasks) {
        this.subtasks = subtasks;
    }

    public Time getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Time deadLine) {
        this.deadLine = deadLine;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

}
enum Difficulty{
    REALLY_EFFORTLESS,
    VERY_EASY,
    EASY,
    MEDIUM,
    HARD,
    VERY_HARD,
    REALLY_CHALLENGING
}
