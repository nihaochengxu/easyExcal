package com.it.easyexcal.listToMap;

import com.sun.javafx.collections.MappingChange;
import org.springframework.expression.spel.ast.VariableReference;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author WQC
 * @Date 2022/6/22 22:45
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<Object>();
        Student student = new Student();
        student.setId(1);
        student.setAge(20);
        student.setName("one");
        Student student2 = new Student();
        student2.setId(2);
        student2.setAge(15);
        student2.setName("two");
        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        map.put(1, "sb了");
        map2.put(2, "不sb了");
        students.add(student);
        students.add(student2);
        objects.add(map);
        objects.add(map2);
        System.out.println(students);
        List<Student> collect1 = students.stream().filter(p -> p.getAge() > 16).collect(Collectors.toList());
        System.out.println(collect1);

//        Map<Integer, Student> collect = students.stream().collect(Collectors.toMap(Student::getId,o -> o ));
//        Map<Set<Integer>, Object> collect1 = objects.stream().collect(Collectors.toMap(o -> {
//            Map<Integer, Object> o1 = (Map<Integer, Object>) o;
//
//            return o1.get();
//        }, o -> o));
//        System.out.println(collect1);
//        List<Object> objectList = students.stream().map(o -> {
//            Map<Integer, Object> o1 = (Map<Integer, Object>) o;
//            return o1.get(1);
//            Student o1 = (Student) o;
//            return o1.getId();
//        }).collect(Collectors.toList());
//        System.out.println(objectList);
//        collect.keySet().forEach(e ->{
//            System.out.println(e.intValue());
//        });
//        collect.entrySet().forEach(s ->{
//            System.out.println(s);
//        });
//        for (Map.Entry<Integer, Student> integerStudentEntry : collect.entrySet()) {
//            System.out.println(integerStudentEntry.getValue());
//            System.out.println(integerStudentEntry.getKey());
//        }
//        for (Integer i : collect.keySet()) {
//            System.out.println(i+":"+collect.get(i));
//        }
//        HashMap<Integer, Object> objectHashMap = new HashMap<>();
//        for (int i = 0; i < objects.size(); i++) {
//            Map<Integer, Object> o = (Map<Integer,Object>)objects.get(i);
//            objectHashMap.put(i, o);
//        }
//        System.out.println(objectHashMap);
    }
}
