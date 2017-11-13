/*
 * Copyright 2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.android.anko;

import org.jetbrains.android.anko.utils.ClassTree;
import org.jetbrains.android.anko.utils.NoSuchClassException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.tree.ClassNode;

import java.util.ArrayList;
import java.util.Collections;

public class ClassTreeTest extends Assert {

    private final ArrayList<ClassNode> classes = new ArrayList<>();
    private ArrayList<ClassNode> shuffledClasses;

    @Before
    public void setUp() throws Exception {
        classes.clear();
        classes.add(createNode("java.lang.Object", null));
        classes.add(createNode("java.lang.Integer", "java.lang.Object"));
        classes.add(createNode("com.example.A", "java.lang.Object"));
        classes.add(createNode("com.example.B", "com.example.A"));
        classes.add(createNode("com.example.C", "com.example.A"));
        classes.add(createNode("com.example.D", "com.example.B"));
        classes.add(createNode("com.example.E", "com.example.B"));
        classes.add(createNode("com.example.F", "com.example.E"));
        classes.add(createNode("com.example.G", "com.example.F"));
        classes.add(createNode("com.example.H", "com.example.F"));
        shuffledClasses = new ArrayList<>(classes);
        Collections.shuffle(shuffledClasses);
    }

    private void doAdd(ClassTree target) {
        for (ClassNode aClass : shuffledClasses) {
            target.add(aClass, true);
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

    @Test(expected = NoSuchClassException.class)
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
    
    private static ClassNode createNode(String name, String superName) {
        ClassNode node = new ClassNode();
        node.name = name;
        node.superName = superName;
        return node;
    }
}
