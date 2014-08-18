package com.jetbrains.android.dsl.tests;

import com.jetbrains.android.dsl.*;
import org.objectweb.asm.tree.ClassNode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ClassTreeTest extends Assert {

    private final ArrayList<ClassNode> classes = new ArrayList<>();
    private ArrayList<ClassNode> shuffledClasses;

    @BeforeMethod
    public void setUp() throws Exception {
        classes.clear();
        classes.add(new SimpleClassNode("java.lang.Object", null));
        classes.add(new SimpleClassNode("java.lang.Integer", "java.lang.Object"));
        classes.add(new SimpleClassNode("com.example.A", "java.lang.Object"));
        classes.add(new SimpleClassNode("com.example.B", "com.example.A"));
        classes.add(new SimpleClassNode("com.example.C", "com.example.A"));
        classes.add(new SimpleClassNode("com.example.D", "com.example.B"));
        classes.add(new SimpleClassNode("com.example.E", "com.example.B"));
        classes.add(new SimpleClassNode("com.example.F", "com.example.E"));
        classes.add(new SimpleClassNode("com.example.G", "com.example.F"));
        classes.add(new SimpleClassNode("com.example.H", "com.example.F"));
        shuffledClasses = new ArrayList<>(classes);
        Collections.shuffle(shuffledClasses);
    }

    private void doAdd(ClassTree target) {
        for (ClassNode aClass : shuffledClasses) {
            target.add(aClass);
        }
    }

    @Test
    public void testAdd() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
    }

    @Test
    public void testIsChild() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
        assertTrue(tree.isChildOf(classes.get(1), "java.lang.Object"));
        assertTrue(tree.isChildOf(classes.get(2), "java.lang.Object"));
        assertFalse(tree.isChildOf(classes.get(3), "java.lang.Object"));
    }

    @Test
    public void testIsSuccessorOf() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
        assertTrue(tree.isSuccessorOf(classes.get(1), "java.lang.Object"));
        assertTrue(tree.isSuccessorOf(classes.get(2), "java.lang.Object"));
        assertTrue(tree.isSuccessorOf(classes.get(3), "com.example.A"));
        assertTrue(tree.isSuccessorOf(classes.get(3), "java.lang.Object"));
        assertTrue(tree.isSuccessorOf(classes.get(4), "com.example.A"));
        assertTrue(tree.isSuccessorOf(classes.get(5), "com.example.A"));
        assertTrue(tree.isSuccessorOf(classes.get(6), "com.example.A"));
        assertTrue(tree.isSuccessorOf(classes.get(7), "com.example.E"));
        assertFalse(tree.isSuccessorOf(classes.get(3), "java.lang.Integer"));
        assertFalse(tree.isSuccessorOf(classes.get(2), "com.example.B"));
        assertFalse(tree.isSuccessorOf(classes.get(2), "java.lang.Integer"));
        assertFalse(tree.isSuccessorOf(classes.get(0), "java.lang.Object"));
    }

    @Test(expectedExceptions = NoSuchClassException.class)
    public void testNoSuchClassException() throws Exception {
        ClassTree tree = new ClassTree();
        ClassNode cn = new ClassNode();
        cn.name = "java.lang.Integer";
        tree.isSuccessorOf(cn, "java.util.List");
    }

    @Test
    public void testTreeIterator() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
        int arrayElementCount = classes.size();
        int treeElementCount = 0;
        for (ClassNode c : tree) {
            assertTrue(classes.contains(c));
            ++treeElementCount;
        }
        assertEquals(arrayElementCount, treeElementCount);
    }

    class SimpleClassNode extends ClassNode {
        SimpleClassNode(String name, String superName) {
            this.name = name;
            this.superName = superName;
        }
    }

}
