package com.task.service;

import com.task.model.Notification;
import com.task.model.Space;
import com.task.model.Task;
import com.task.proxy.UserProxy;
import com.task.repository.SpaceRepository;
import com.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    UserProxy userProxy;
    //*************** Working ********************
    public Space saveTask(Task task,String spaceName,String email) {
        System.out.println("*** task service *********  ");
        Space space = spaceRepository.findBySpaceNameAndEmail(spaceName,email);
        System.out.println("*** spaceRepository.findBySpaceNameAndEmail(spaceName,email) ***");
        System.out.println(space);

        UUID uuid=UUID.randomUUID();
        String id = String.valueOf(uuid);
        task.setTaskId(id);

        List<String> emailList = space.getEmail();
        emailList.forEach(i-> System.out.println(i));
        System.out.println(task.getEmail());

        Notification notification = new Notification();
        notification.setEmail(email);
        notification.setSpaceName(spaceName);
        notification.setTaskName(task.getTaskName());
        notification.setTaskAssign(task.getEmail());
        notification.setTaskStatus("To-Do");

        System.out.println("39 : "+notification);

        if (space.getSpaceName().equals(spaceName)){
            System.out.println("==== space.getSpaceName().equals(spaceName) ====");
            if (space.getTaskList() == null){
                space.setTaskList(Arrays.asList(task));
                System.out.println(space);
                userProxy.saveTaskNotification(notification);
                spaceRepository.save(space);
            }else {
                System.out.println("======  else condisence=======");
                List list = space.getTaskList();
                list.add(task);

                space.setTaskList(list);
                userProxy.saveTaskNotification(notification);
                spaceRepository.save(space);
            }
        }
        return space;
    }
    public Task updateTask(Task task,String spaceName, String email) {
        Space space = spaceRepository.findBySpaceName(spaceName);
        List<Task> tasks = space.getTaskList();
        List<Task> newTasks = new ArrayList();
        for(Task t: tasks) {
            if(Objects.equals(t.getTaskId(), task.getTaskId()))
                newTasks.add(task);
            else newTasks.add(t);
        }
        space.setTaskList(newTasks);
        spaceRepository.save(space);
        return task;
    }


    public Space deleteTask(String spaceName, String taskId) {
        Space space = spaceRepository.findBySpaceName(spaceName);
        List<Task> taskList = space.getTaskList();
        List<Task> newTaskList = taskList.stream()
                .filter(i -> !Objects.equals(i.getTaskId().toString(), taskId))
                .collect(Collectors.toList());
        if(newTaskList.isEmpty()){
            space.setTaskList(null);
        }
        else
        space.setTaskList(newTaskList);
        spaceRepository.save(space);
        return space;
    }

    //*************** Working ********************
    public List<Space> getAllUser() {
        List<Space> list = spaceRepository.findAll();
        list.stream().forEach(i-> System.out.println(i));
        return (List<Space>) spaceRepository.findAll();
    }

    //*************** Working ********************
    public List<Task> getTask(String spaceName,String email) {
        Space space = spaceRepository.findBySpaceNameAndEmail(spaceName,email);
        List<String> emailList = space.getEmail();
        System.out.println(emailList);

        if (space != null){
            System.out.println(space);
            for (String s:emailList){
                if (s.equals(email)){
                    List<Task> taskList = space.getTaskList();
                    return taskList;
                }
            }
        }
        return null;
    }




}














//    public Space deleteTask(String email, String id) {
//        Space space = spaceRepository.findByEmail(email);
//        System.out.println("delete taske method service");
//        List<Task> taskList = space.getTaskList();
//        Task task = taskRepository.findByEmail(email);
//
//        if (space.getEmail().equals(email)){
//            for (Task task1 : taskList){
//                if (task1.getTaskId().equals(id)){
//                    System.out.println("//////**** delete taske method service  ****///////");
//                    space.getTaskList().remove(task1);
//                    System.out.println("movie temporary vareiable "+task1);
//                    return spaceRepository.save(space);
//                }
//            }
//        }
//
//        return space;
//    }


//    public List<Task> getTask(String spaceName, String taskName, String email) {
//        Space space = spaceRepository.findBySpaceNameAndEmail(spaceName,email);
//        List<String> emailList = space.getEmail();
//        System.out.println(emailList);
//
//        if (space != null){
//            System.out.println(space);
//            for (String s:emailList){
//                if (s.equals(email)){
//                    List<Task> taskList = space.getTaskList();
//                    return taskList;
//                }
//            }
//        }
//
////        if (space != null){
////            System.out.println(space);
////            for (String task:emailList){
////                if (task.equals(email)){
////                    System.out.println("line 141 "+task);
////                    List<Task> taskList = space.getTaskList();
////                    for (Task task1:taskList){
////                        if (task1.getTaskName().equals(taskName)){
////                            Task task11 = task1;
////                            return  task11;
//////                            return taskRepository.findAll();
////                        }
////                    }
////                    System.out.println(taskList);
////                }
////            }
////        }
//        return null;
//    }


//    public Space savetoBeDone(String toBeDone,String email) {
//        Space space = spaceRepository.findByEmail(email);
//        System.out.println(space.getEmail()+" spaceRepository.findByEmail(email); ");
//        List<Task> taskList = space.getTaskList();
//        TaskStatus taskStatus= new TaskStatus();
//
//        if (space.getEmail().equals(email)){
//            for (Task task:taskList){
//                if (task.getEmail().equals(email)){
//                    if (task.getTaskStatusList() == null){
//                        taskStatus.setToBeDone(Collections.singletonList(toBeDone));
//                        task.setTaskStatusList(Arrays.asList(taskStatus));
//                        List list = space.getTaskList();
//                        list.add(task);
//                        space.setTaskList(list);
//                        System.out.println("line 109");
//                        System.out.println(space);
//                        return spaceRepository.save(space);
//                    }else {
//                        List list1 = task.getTaskStatusList();
//                        taskStatus.setToBeDone(Collections.singletonList(toBeDone));
//                        list1.add(taskStatus);
//
//                        List list = space.getTaskList();
//                        list.add(list1);
//                        space.setTaskList(list);
//                        System.out.println("line 119 ");
//                        System.out.println(space);
//                        return spaceRepository.save(space);
//                    }
//                }
//            }
//        }
//        return space;
//    }