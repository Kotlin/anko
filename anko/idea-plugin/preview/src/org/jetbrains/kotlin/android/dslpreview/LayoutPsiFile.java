/*
 * Copyright 2015 JetBrains s.r.o.
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

package org.jetbrains.kotlin.android.dslpreview;

import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiElementProcessor;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/*
  Reason for these stubs:
  Android Preview checks that the xml file is placed inside "layout-*" directory.
 */
public class LayoutPsiFile implements XmlFile {

    private final XmlFile myPsiFile;
    private final PsiDirectory myPsiDirectory;

    public LayoutPsiFile(XmlFile psiFile) {
        this.myPsiFile = psiFile;
        myPsiDirectory = new LayoutPsiDirectory();
    }

    @Override
    public PsiDirectory getParent() {
        return myPsiDirectory;
    }

    @Override
    @Nullable
    public XmlDocument getDocument() {
        return myPsiFile.getDocument();
    }

    @Override
    @Nullable
    public XmlTag getRootTag() {
        return myPsiFile.getRootTag();
    }

    @Override
    public VirtualFile getVirtualFile() {
        return myPsiFile.getVirtualFile();
    }

    @Override
    public PsiDirectory getContainingDirectory() {
        return myPsiFile.getContainingDirectory();
    }

    @Override
    public long getModificationStamp() {
        return myPsiFile.getModificationStamp();
    }

    @Override
    @NotNull
    public PsiFile getOriginalFile() {
        return myPsiFile.getOriginalFile();
    }

    @Override
    @NotNull
    public FileType getFileType() {
        return myPsiFile.getFileType();
    }

    @Override
    @NotNull
    public FileViewProvider getViewProvider() {
        return myPsiFile.getViewProvider();
    }

    @Override
    public FileASTNode getNode() {
        return myPsiFile.getNode();
    }

    @Override
    @Deprecated
    @NotNull
    @SuppressWarnings("deprecation")
    public PsiFile[] getPsiRoots() {
        return myPsiFile.getPsiRoots();
    }

    @Override
    public void subtreeChanged() {
        myPsiFile.subtreeChanged();
    }

    @Override
    public boolean isDirectory() {
        return myPsiFile.isDirectory();
    }

    @Override
    @NotNull
    @NonNls
    public String getName() {
        return myPsiFile.getName();
    }

    @Override
    public boolean processChildren(PsiElementProcessor<PsiFileSystemItem> psiFileSystemItemPsiElementProcessor) {
        return myPsiFile.processChildren(psiFileSystemItemPsiElementProcessor);
    }

    @Override
    public void checkSetName(String s) throws IncorrectOperationException {
        myPsiFile.checkSetName(s);
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String s) throws IncorrectOperationException {
        return myPsiFile.setName(s);
    }

    @Override
    @NotNull
    public Project getProject() throws PsiInvalidElementAccessException {
        return myPsiFile.getProject();
    }

    @Override
    @NotNull
    public Language getLanguage() {
        return myPsiFile.getLanguage();
    }

    @Override
    public PsiManager getManager() {
        return myPsiFile.getManager();
    }

    @Override
    @NotNull
    public PsiElement[] getChildren() {
        return myPsiFile.getChildren();
    }

    @Override
    public PsiElement getFirstChild() {
        return myPsiFile.getFirstChild();
    }

    @Override
    public PsiElement getLastChild() {
        return myPsiFile.getLastChild();
    }

    @Override
    public PsiElement getNextSibling() {
        return myPsiFile.getNextSibling();
    }

    @Override
    public PsiElement getPrevSibling() {
        return myPsiFile.getPrevSibling();
    }

    @Override
    public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
        return myPsiFile.getContainingFile();
    }

    @Override
    public TextRange getTextRange() {
        return myPsiFile.getTextRange();
    }

    @Override
    public int getStartOffsetInParent() {
        return myPsiFile.getStartOffsetInParent();
    }

    @Override
    public int getTextLength() {
        return myPsiFile.getTextLength();
    }

    @Override
    @Nullable
    public PsiElement findElementAt(int i) {
        return myPsiFile.findElementAt(i);
    }

    @Override
    @Nullable
    public PsiReference findReferenceAt(int i) {
        return myPsiFile.findReferenceAt(i);
    }

    @Override
    public int getTextOffset() {
        return myPsiFile.getTextOffset();
    }

    @Override
    @NonNls
    public String getText() {
        return myPsiFile.getText();
    }

    @Override
    @NotNull
    public char[] textToCharArray() {
        return myPsiFile.textToCharArray();
    }

    @Override
    public PsiElement getNavigationElement() {
        return myPsiFile.getNavigationElement();
    }

    @Override
    public PsiElement getOriginalElement() {
        return myPsiFile.getOriginalElement();
    }

    @Override
    public boolean textMatches(@NotNull @NonNls CharSequence charSequence) {
        return myPsiFile.textMatches(charSequence);
    }

    @Override
    public boolean textMatches(@NotNull PsiElement psiElement) {
        return myPsiFile.textMatches(psiElement);
    }

    @Override
    public boolean textContains(char c) {
        return myPsiFile.textContains(c);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor psiElementVisitor) {
        myPsiFile.accept(psiElementVisitor);
    }

    @Override
    public void acceptChildren(@NotNull PsiElementVisitor psiElementVisitor) {
        myPsiFile.acceptChildren(psiElementVisitor);
    }

    @Override
    public PsiElement copy() {
        return myPsiFile.copy();
    }

    @Override
    public PsiElement add(@NotNull PsiElement psiElement) throws IncorrectOperationException {
        return myPsiFile.add(psiElement);
    }

    @Override
    public PsiElement addBefore(@NotNull PsiElement psiElement, @Nullable PsiElement psiElement2) throws IncorrectOperationException {
        return myPsiFile.addBefore(psiElement, psiElement2);
    }

    @Override
    public PsiElement addAfter(@NotNull PsiElement psiElement, @Nullable PsiElement psiElement2) throws IncorrectOperationException {
        return myPsiFile.addAfter(psiElement, psiElement2);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void checkAdd(@NotNull PsiElement psiElement) throws IncorrectOperationException {
        myPsiFile.checkAdd(psiElement);
    }

    @Override
    public PsiElement addRange(PsiElement psiElement, PsiElement psiElement2) throws IncorrectOperationException {
        return myPsiFile.addRange(psiElement, psiElement2);
    }

    @Override
    public PsiElement addRangeBefore(@NotNull PsiElement psiElement, @NotNull PsiElement psiElement2, PsiElement psiElement3) throws IncorrectOperationException {
        return myPsiFile.addRangeBefore(psiElement, psiElement2, psiElement3);
    }

    @Override
    public PsiElement addRangeAfter(PsiElement psiElement, PsiElement psiElement2, PsiElement psiElement3) throws IncorrectOperationException {
        return myPsiFile.addRangeAfter(psiElement, psiElement2, psiElement3);
    }

    @Override
    public void delete() throws IncorrectOperationException {
        myPsiFile.delete();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void checkDelete() throws IncorrectOperationException {
        myPsiFile.checkDelete();
    }

    @Override
    public void deleteChildRange(PsiElement psiElement, PsiElement psiElement2) throws IncorrectOperationException {
        myPsiFile.deleteChildRange(psiElement, psiElement2);
    }

    @Override
    public PsiElement replace(@NotNull PsiElement psiElement) throws IncorrectOperationException {
        return myPsiFile.replace(psiElement);
    }

    @Override
    public boolean isValid() {
        return myPsiFile.isValid();
    }

    @Override
    public boolean isWritable() {
        return myPsiFile.isWritable();
    }

    @Override
    @Nullable
    public PsiReference getReference() {
        return myPsiFile.getReference();
    }

    @Override
    @NotNull
    public PsiReference[] getReferences() {
        return myPsiFile.getReferences();
    }

    @Override
    @Nullable
    public <T> T getCopyableUserData(Key<T> tKey) {
        return myPsiFile.getCopyableUserData(tKey);
    }

    @Override
    public <T> void putCopyableUserData(Key<T> tKey, @Nullable T t) {
        myPsiFile.putCopyableUserData(tKey, t);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor psiScopeProcessor, @NotNull ResolveState resolveState, @Nullable PsiElement psiElement, @NotNull PsiElement psiElement2) {
        return myPsiFile.processDeclarations(psiScopeProcessor, resolveState, psiElement, psiElement2);
    }

    @Override
    @Nullable
    public PsiElement getContext() {
        return myPsiFile.getContext();
    }

    @Override
    public boolean isPhysical() {
        return myPsiFile.isPhysical();
    }

    @Override
    @NotNull
    public GlobalSearchScope getResolveScope() {
        return myPsiFile.getResolveScope();
    }

    @Override
    @NotNull
    public SearchScope getUseScope() {
        return myPsiFile.getUseScope();
    }

    @Override
    @NonNls
    public String toString() {
        return myPsiFile.toString();
    }

    @Override
    public boolean isEquivalentTo(PsiElement psiElement) {
        return myPsiFile.isEquivalentTo(psiElement);
    }

    @Override
    @Nullable
    public <T> T getUserData(@NotNull Key<T> tKey) {
        return myPsiFile.getUserData(tKey);
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> tKey, @Nullable T t) {
        myPsiFile.putUserData(tKey, t);
    }

    @Override
    public Icon getIcon(@IconFlags int i) {
        return myPsiFile.getIcon(i);
    }

    @Override
    @Nullable
    public ItemPresentation getPresentation() {
        return myPsiFile.getPresentation();
    }

    @Override
    public void navigate(boolean b) {
        myPsiFile.navigate(b);
    }

    @Override
    public boolean canNavigate() {
        return myPsiFile.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return myPsiFile.canNavigateToSource();
    }

    @Override
    public boolean processElements(PsiElementProcessor psiElementProcessor, PsiElement psiElement) {
        return myPsiFile.processElements(psiElementProcessor, psiElement);
    }

    @NotNull
    @Override
    public GlobalSearchScope getFileResolveScope() {
        return myPsiFile.getFileResolveScope();
    }

    @Override
    public boolean ignoreReferencedElementAccessibility() {
        return myPsiFile.ignoreReferencedElementAccessibility();
    }

    @SuppressWarnings("ConstantConditions")
    private static class LayoutPsiDirectory implements PsiDirectory {

        @NotNull
        @Override
        public String getName() {
            return "layout";
        }

        @NotNull
        @Override
        public VirtualFile getVirtualFile() {
            return null;
        }

        @NotNull
        @Override
        public PsiElement setName(@NotNull String s) throws IncorrectOperationException {
            return null;
        }

        @Nullable
        @Override
        public PsiDirectory getParentDirectory() {
            return null;
        }

        @Nullable
        @Override
        public PsiDirectory getParent() {
            return null;
        }

        @NotNull
        @Override
        public PsiDirectory[] getSubdirectories() {
            return new PsiDirectory[0];
        }

        @NotNull
        @Override
        public PsiFile[] getFiles() {
            return new PsiFile[0];
        }

        @Nullable
        @Override
        public PsiDirectory findSubdirectory(@NotNull String s) {
            return null;
        }

        @Nullable
        @Override
        public PsiFile findFile(@NotNull @NonNls String s) {
            return null;
        }

        @NotNull
        @Override
        public PsiDirectory createSubdirectory(@NotNull String s) throws IncorrectOperationException {
            return null;
        }

        @Override
        public void checkCreateSubdirectory(@NotNull String s) throws IncorrectOperationException {

        }

        @NotNull
        @Override
        public PsiFile createFile(@NotNull @NonNls String s) throws IncorrectOperationException {
            return null;
        }

        @NotNull
        @Override
        public PsiFile copyFileFrom(@NotNull String s, @NotNull PsiFile psiFile) throws IncorrectOperationException {
            return null;
        }

        @Override
        public void checkCreateFile(@NotNull String s) throws IncorrectOperationException {

        }

        @Override
        public boolean isDirectory() {
            return true;
        }

        @Override
        public boolean processChildren(PsiElementProcessor<PsiFileSystemItem> psiFileSystemItemPsiElementProcessor) {
            return false;
        }

        @Nullable
        @Override
        public ItemPresentation getPresentation() {
            return null;
        }

        @Override
        public void navigate(boolean b) {

        }

        @Override
        public boolean canNavigate() {
            return false;
        }

        @Override
        public boolean canNavigateToSource() {
            return false;
        }

        @Override
        public void checkSetName(String s) throws IncorrectOperationException {

        }

        @NotNull
        @Override
        public Project getProject() throws PsiInvalidElementAccessException {
            return null;
        }

        @NotNull
        @Override
        public Language getLanguage() {
            return null;
        }

        @Override
        public PsiManager getManager() {
            return null;
        }

        @NotNull
        @Override
        public PsiElement[] getChildren() {
            return new PsiElement[0];
        }

        @Override
        public PsiElement getFirstChild() {
            return null;
        }

        @Override
        public PsiElement getLastChild() {
            return null;
        }

        @Override
        public PsiElement getNextSibling() {
            return null;
        }

        @Override
        public PsiElement getPrevSibling() {
            return null;
        }

        @Override
        public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
            return null;
        }

        @Override
        public TextRange getTextRange() {
            return null;
        }

        @Override
        public int getStartOffsetInParent() {
            return 0;
        }

        @Override
        public int getTextLength() {
            return 0;
        }

        @Nullable
        @Override
        public PsiElement findElementAt(int i) {
            return null;
        }

        @Nullable
        @Override
        public PsiReference findReferenceAt(int i) {
            return null;
        }

        @Override
        public int getTextOffset() {
            return 0;
        }

        @Override
        public String getText() {
            return null;
        }

        @NotNull
        @Override
        public char[] textToCharArray() {
            return new char[0];
        }

        @Override
        public PsiElement getNavigationElement() {
            return null;
        }

        @Override
        public PsiElement getOriginalElement() {
            return null;
        }

        @Override
        public boolean textMatches(@NotNull @NonNls CharSequence charSequence) {
            return false;
        }

        @Override
        public boolean textMatches(@NotNull PsiElement psiElement) {
            return false;
        }

        @Override
        public boolean textContains(char c) {
            return false;
        }

        @Override
        public void accept(@NotNull PsiElementVisitor psiElementVisitor) {

        }

        @Override
        public void acceptChildren(@NotNull PsiElementVisitor psiElementVisitor) {

        }

        @Override
        public PsiElement copy() {
            return null;
        }

        @Override
        public PsiElement add(@NotNull PsiElement psiElement) throws IncorrectOperationException {
            return null;
        }

        @Override
        public PsiElement addBefore(@NotNull PsiElement psiElement, @Nullable PsiElement psiElement2) throws IncorrectOperationException {
            return null;
        }

        @Override
        public PsiElement addAfter(@NotNull PsiElement psiElement, @Nullable PsiElement psiElement2) throws IncorrectOperationException {
            return null;
        }

        @Override
        public void checkAdd(@NotNull PsiElement psiElement) throws IncorrectOperationException {

        }

        @Override
        public PsiElement addRange(PsiElement psiElement, PsiElement psiElement2) throws IncorrectOperationException {
            return null;
        }

        @Override
        public PsiElement addRangeBefore(@NotNull PsiElement psiElement, @NotNull PsiElement psiElement2, PsiElement psiElement3) throws IncorrectOperationException {
            return null;
        }

        @Override
        public PsiElement addRangeAfter(PsiElement psiElement, PsiElement psiElement2, PsiElement psiElement3) throws IncorrectOperationException {
            return null;
        }

        @Override
        public void delete() throws IncorrectOperationException {

        }

        @Override
        public void checkDelete() throws IncorrectOperationException {

        }

        @Override
        public void deleteChildRange(PsiElement psiElement, PsiElement psiElement2) throws IncorrectOperationException {

        }

        @Override
        public PsiElement replace(@NotNull PsiElement psiElement) throws IncorrectOperationException {
            return null;
        }

        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public boolean isWritable() {
            return false;
        }

        @Nullable
        @Override
        public PsiReference getReference() {
            return null;
        }

        @NotNull
        @Override
        public PsiReference[] getReferences() {
            return new PsiReference[0];
        }

        @Nullable
        @Override
        public <T> T getCopyableUserData(Key<T> tKey) {
            return null;
        }

        @Override
        public <T> void putCopyableUserData(Key<T> tKey, @Nullable T t) {

        }

        @Override
        public boolean processDeclarations(@NotNull PsiScopeProcessor psiScopeProcessor, @NotNull ResolveState resolveState, @Nullable PsiElement psiElement, @NotNull PsiElement psiElement2) {
            return false;
        }

        @Nullable
        @Override
        public PsiElement getContext() {
            return null;
        }

        @Override
        public boolean isPhysical() {
            return false;
        }

        @NotNull
        @Override
        public GlobalSearchScope getResolveScope() {
            return null;
        }

        @NotNull
        @Override
        public SearchScope getUseScope() {
            return null;
        }

        @Override
        public ASTNode getNode() {
            return null;
        }

        @Override
        public boolean isEquivalentTo(PsiElement psiElement) {
            return false;
        }

        @Override
        public Icon getIcon(@IconFlags int i) {
            return null;
        }

        @Nullable
        @Override
        public <T> T getUserData(@NotNull Key<T> tKey) {
            return null;
        }

        @Override
        public <T> void putUserData(@NotNull Key<T> tKey, @Nullable T t) {

        }
    }

}