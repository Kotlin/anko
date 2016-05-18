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

@file:Suppress("UNREACHABLE_CODE", "OverridingDeprecatedMember", "DEPRECATION")
package org.jetbrains.kotlin.android.dslpreview

import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.lang.Language
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable.IconFlags
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.*
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.PsiElementProcessor
import com.intellij.psi.search.SearchScope
import com.intellij.psi.xml.XmlDocument
import com.intellij.psi.xml.XmlFile
import com.intellij.psi.xml.XmlTag
import com.intellij.util.IncorrectOperationException
import org.jetbrains.annotations.NonNls

import javax.swing.*

/*
  Reason for these stubs:
  Android Preview checks that the xml file is placed inside "layout-*" directory.
 */
class LayoutPsiFile(private val myPsiFile: XmlFile) : XmlFile {
    private val myPsiDirectory: PsiDirectory

    init {
        myPsiDirectory = LayoutPsiDirectory()
    }

    override fun getParent(): PsiDirectory? {
        return myPsiDirectory
    }

    override fun getDocument(): XmlDocument? {
        return myPsiFile.document
    }

    override fun getRootTag(): XmlTag? {
        return myPsiFile.rootTag
    }

    override fun getVirtualFile(): VirtualFile {
        return myPsiFile.virtualFile
    }

    override fun getContainingDirectory(): PsiDirectory {
        return myPsiFile.containingDirectory
    }

    override fun getModificationStamp(): Long {
        return myPsiFile.modificationStamp
    }

    override fun getOriginalFile(): PsiFile {
        return myPsiFile.originalFile
    }

    override fun getFileType(): FileType {
        return myPsiFile.fileType
    }

    override fun getViewProvider(): FileViewProvider {
        return myPsiFile.viewProvider
    }

    override fun getNode(): FileASTNode {
        return myPsiFile.node
    }

    @Deprecated("")
    @SuppressWarnings("deprecation")
    override fun getPsiRoots(): Array<PsiFile> {
        return myPsiFile.psiRoots
    }

    override fun subtreeChanged() {
        myPsiFile.subtreeChanged()
    }

    override fun isDirectory(): Boolean {
        return myPsiFile.isDirectory
    }

    @NonNls
    override fun getName(): String {
        return myPsiFile.name
    }

    override fun processChildren(psiFileSystemItemPsiElementProcessor: PsiElementProcessor<PsiFileSystemItem>): Boolean {
        return myPsiFile.processChildren(psiFileSystemItemPsiElementProcessor)
    }

    @Throws(IncorrectOperationException::class)
    override fun checkSetName(s: String) {
        myPsiFile.checkSetName(s)
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(@NonNls s: String): PsiElement {
        return myPsiFile.setName(s)
    }

    @Throws(PsiInvalidElementAccessException::class)
    override fun getProject(): Project {
        return myPsiFile.project
    }

    override fun getLanguage(): Language {
        return myPsiFile.language
    }

    override fun getManager(): PsiManager {
        return myPsiFile.manager
    }

    override fun getChildren(): Array<PsiElement> {
        return myPsiFile.children
    }

    override fun getFirstChild(): PsiElement {
        return myPsiFile.firstChild
    }

    override fun getLastChild(): PsiElement {
        return myPsiFile.lastChild
    }

    override fun getNextSibling(): PsiElement {
        return myPsiFile.nextSibling
    }

    override fun getPrevSibling(): PsiElement {
        return myPsiFile.prevSibling
    }

    @Throws(PsiInvalidElementAccessException::class)
    override fun getContainingFile(): PsiFile {
        return myPsiFile.containingFile
    }

    override fun getTextRange(): TextRange {
        return myPsiFile.textRange
    }

    override fun getStartOffsetInParent(): Int {
        return myPsiFile.startOffsetInParent
    }

    override fun getTextLength(): Int {
        return myPsiFile.textLength
    }

    override fun findElementAt(i: Int): PsiElement? {
        return myPsiFile.findElementAt(i)
    }

    override fun findReferenceAt(i: Int): PsiReference? {
        return myPsiFile.findReferenceAt(i)
    }

    override fun getTextOffset(): Int {
        return myPsiFile.textOffset
    }

    @NonNls
    override fun getText(): String {
        return myPsiFile.text
    }

    override fun textToCharArray(): CharArray {
        return myPsiFile.textToCharArray()
    }

    override fun getNavigationElement(): PsiElement {
        return myPsiFile.navigationElement
    }

    override fun getOriginalElement(): PsiElement {
        return myPsiFile.originalElement
    }

    override fun textMatches(@NonNls charSequence: CharSequence): Boolean {
        return myPsiFile.textMatches(charSequence)
    }

    override fun textMatches(psiElement: PsiElement): Boolean {
        return myPsiFile.textMatches(psiElement)
    }

    override fun textContains(c: Char): Boolean {
        return myPsiFile.textContains(c)
    }

    override fun accept(psiElementVisitor: PsiElementVisitor) {
        myPsiFile.accept(psiElementVisitor)
    }

    override fun acceptChildren(psiElementVisitor: PsiElementVisitor) {
        myPsiFile.acceptChildren(psiElementVisitor)
    }

    override fun copy(): PsiElement {
        return myPsiFile.copy()
    }

    @Throws(IncorrectOperationException::class)
    override fun add(psiElement: PsiElement): PsiElement {
        return myPsiFile.add(psiElement)
    }

    @Throws(IncorrectOperationException::class)
    override fun addBefore(psiElement: PsiElement, psiElement2: PsiElement?): PsiElement {
        return myPsiFile.addBefore(psiElement, psiElement2)
    }

    @Throws(IncorrectOperationException::class)
    override fun addAfter(psiElement: PsiElement, psiElement2: PsiElement?): PsiElement {
        return myPsiFile.addAfter(psiElement, psiElement2)
    }

    @SuppressWarnings("deprecation")
    @Throws(IncorrectOperationException::class)
    override fun checkAdd(psiElement: PsiElement) {
        myPsiFile.checkAdd(psiElement)
    }

    @Throws(IncorrectOperationException::class)
    override fun addRange(psiElement: PsiElement, psiElement2: PsiElement): PsiElement {
        return myPsiFile.addRange(psiElement, psiElement2)
    }

    @Throws(IncorrectOperationException::class)
    override fun addRangeBefore(psiElement: PsiElement, psiElement2: PsiElement, psiElement3: PsiElement): PsiElement {
        return myPsiFile.addRangeBefore(psiElement, psiElement2, psiElement3)
    }

    @Throws(IncorrectOperationException::class)
    override fun addRangeAfter(psiElement: PsiElement, psiElement2: PsiElement, psiElement3: PsiElement): PsiElement {
        return myPsiFile.addRangeAfter(psiElement, psiElement2, psiElement3)
    }

    @Throws(IncorrectOperationException::class)
    override fun delete() {
        myPsiFile.delete()
    }

    @SuppressWarnings("deprecation")
    @Throws(IncorrectOperationException::class)
    override fun checkDelete() {
        myPsiFile.checkDelete()
    }

    @Throws(IncorrectOperationException::class)
    override fun deleteChildRange(psiElement: PsiElement, psiElement2: PsiElement) {
        myPsiFile.deleteChildRange(psiElement, psiElement2)
    }

    @Throws(IncorrectOperationException::class)
    override fun replace(psiElement: PsiElement): PsiElement {
        return myPsiFile.replace(psiElement)
    }

    override fun isValid(): Boolean {
        return myPsiFile.isValid
    }

    override fun isWritable(): Boolean {
        return myPsiFile.isWritable
    }

    override fun getReference(): PsiReference? {
        return myPsiFile.reference
    }

    override fun getReferences(): Array<PsiReference> {
        return myPsiFile.references
    }

    override fun <T> getCopyableUserData(tKey: Key<T>): T? {
        return myPsiFile.getCopyableUserData(tKey)
    }

    override fun <T> putCopyableUserData(tKey: Key<T>, t: T?) {
        myPsiFile.putCopyableUserData(tKey, t)
    }

    override fun processDeclarations(psiScopeProcessor: PsiScopeProcessor, resolveState: ResolveState, psiElement: PsiElement?, psiElement2: PsiElement): Boolean {
        return myPsiFile.processDeclarations(psiScopeProcessor, resolveState, psiElement, psiElement2)
    }

    override fun getContext(): PsiElement? {
        return myPsiFile.context
    }

    override fun isPhysical(): Boolean {
        return myPsiFile.isPhysical
    }

    override fun getResolveScope(): GlobalSearchScope {
        return myPsiFile.resolveScope
    }

    override fun getUseScope(): SearchScope {
        return myPsiFile.useScope
    }

    @NonNls
    override fun toString(): String {
        return myPsiFile.toString()
    }

    override fun isEquivalentTo(psiElement: PsiElement): Boolean {
        return myPsiFile.isEquivalentTo(psiElement)
    }

    override fun <T> getUserData(tKey: Key<T>): T? {
        return myPsiFile.getUserData(tKey)
    }

    override fun <T> putUserData(tKey: Key<T>, t: T?) {
        myPsiFile.putUserData(tKey, t)
    }

    override fun getIcon(@IconFlags i: Int): Icon {
        return myPsiFile.getIcon(i)
    }

    override fun getPresentation(): ItemPresentation? {
        return myPsiFile.presentation
    }

    override fun navigate(b: Boolean) {
        myPsiFile.navigate(b)
    }

    override fun canNavigate(): Boolean {
        return myPsiFile.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return myPsiFile.canNavigateToSource()
    }

    override fun processElements(psiElementProcessor: PsiElementProcessor<PsiElement>, psiElement: PsiElement): Boolean {
        return myPsiFile.processElements(psiElementProcessor, psiElement)
    }

    override fun getFileResolveScope(): GlobalSearchScope {
        return myPsiFile.fileResolveScope
    }

    override fun ignoreReferencedElementAccessibility(): Boolean {
        return myPsiFile.ignoreReferencedElementAccessibility()
    }

    @SuppressWarnings("ConstantConditions")
    private class LayoutPsiDirectory : PsiDirectory {

        override fun getName(): String {
            return "layout"
        }

        override fun getVirtualFile(): VirtualFile {
            return null!!
        }

        @Throws(IncorrectOperationException::class)
        override fun setName(s: String): PsiElement {
            return null!!
        }

        override fun getParentDirectory(): PsiDirectory? {
            return null
        }

        override fun getParent(): PsiDirectory? {
            return null
        }

        override fun getSubdirectories(): Array<PsiDirectory?> {
            return arrayOfNulls(0)
        }

        override fun getFiles(): Array<PsiFile?> {
            return arrayOfNulls(0)
        }

        override fun findSubdirectory(s: String): PsiDirectory? {
            return null
        }

        override fun findFile(@NonNls s: String): PsiFile? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun createSubdirectory(s: String): PsiDirectory {
            return null!!
        }

        @Throws(IncorrectOperationException::class)
        override fun checkCreateSubdirectory(s: String) {

        }

        @Throws(IncorrectOperationException::class)
        override fun createFile(@NonNls s: String): PsiFile {
            return null!!
        }

        @Throws(IncorrectOperationException::class)
        override fun copyFileFrom(s: String, psiFile: PsiFile): PsiFile {
            return null!!
        }

        @Throws(IncorrectOperationException::class)
        override fun checkCreateFile(s: String) {

        }

        override fun isDirectory(): Boolean {
            return true
        }

        override fun processChildren(psiFileSystemItemPsiElementProcessor: PsiElementProcessor<PsiFileSystemItem>): Boolean {
            return false
        }

        override fun getPresentation(): ItemPresentation? {
            return null
        }

        override fun navigate(b: Boolean) {

        }

        override fun canNavigate(): Boolean {
            return false
        }

        override fun canNavigateToSource(): Boolean {
            return false
        }

        @Throws(IncorrectOperationException::class)
        override fun checkSetName(s: String) {

        }

        @Throws(PsiInvalidElementAccessException::class)
        override fun getProject(): Project {
            return null!!
        }

        override fun getLanguage(): Language {
            return null!!
        }

        override fun getManager(): PsiManager? {
            return null
        }

        override fun getChildren(): Array<PsiElement?> {
            return arrayOfNulls(0)
        }

        override fun getFirstChild(): PsiElement? {
            return null
        }

        override fun getLastChild(): PsiElement? {
            return null
        }

        override fun getNextSibling(): PsiElement? {
            return null
        }

        override fun getPrevSibling(): PsiElement? {
            return null
        }

        @Throws(PsiInvalidElementAccessException::class)
        override fun getContainingFile(): PsiFile? {
            return null
        }

        override fun getTextRange(): TextRange? {
            return null
        }

        override fun getStartOffsetInParent(): Int {
            return 0
        }

        override fun getTextLength(): Int {
            return 0
        }

        override fun findElementAt(i: Int): PsiElement? {
            return null
        }

        override fun findReferenceAt(i: Int): PsiReference? {
            return null
        }

        override fun getTextOffset(): Int {
            return 0
        }

        override fun getText(): String? {
            return null
        }

        override fun textToCharArray(): CharArray {
            return CharArray(0)
        }

        override fun getNavigationElement(): PsiElement? {
            return null
        }

        override fun getOriginalElement(): PsiElement? {
            return null
        }

        override fun textMatches(@NonNls charSequence: CharSequence): Boolean {
            return false
        }

        override fun textMatches(psiElement: PsiElement): Boolean {
            return false
        }

        override fun textContains(c: Char): Boolean {
            return false
        }

        override fun accept(psiElementVisitor: PsiElementVisitor) {

        }

        override fun acceptChildren(psiElementVisitor: PsiElementVisitor) {

        }

        override fun copy(): PsiElement? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun add(psiElement: PsiElement): PsiElement? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun addBefore(psiElement: PsiElement, psiElement2: PsiElement?): PsiElement? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun addAfter(psiElement: PsiElement, psiElement2: PsiElement?): PsiElement? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun checkAdd(psiElement: PsiElement) {

        }

        @Throws(IncorrectOperationException::class)
        override fun addRange(psiElement: PsiElement, psiElement2: PsiElement): PsiElement? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun addRangeBefore(psiElement: PsiElement, psiElement2: PsiElement, psiElement3: PsiElement): PsiElement? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun addRangeAfter(psiElement: PsiElement, psiElement2: PsiElement, psiElement3: PsiElement): PsiElement? {
            return null
        }

        @Throws(IncorrectOperationException::class)
        override fun delete() {

        }

        @Throws(IncorrectOperationException::class)
        override fun checkDelete() {

        }

        @Throws(IncorrectOperationException::class)
        override fun deleteChildRange(psiElement: PsiElement, psiElement2: PsiElement) {

        }

        @Throws(IncorrectOperationException::class)
        override fun replace(psiElement: PsiElement): PsiElement? {
            return null
        }

        override fun isValid(): Boolean {
            return false
        }

        override fun isWritable(): Boolean {
            return false
        }

        override fun getReference(): PsiReference? {
            return null
        }

        override fun getReferences(): Array<PsiReference?> {
            return arrayOfNulls(0)
        }

        override fun <T> getCopyableUserData(tKey: Key<T>): T? {
            return null
        }

        override fun <T> putCopyableUserData(tKey: Key<T>, t: T?) {

        }

        override fun processDeclarations(psiScopeProcessor: PsiScopeProcessor, resolveState: ResolveState, psiElement: PsiElement?, psiElement2: PsiElement): Boolean {
            return false
        }

        override fun getContext(): PsiElement? {
            return null
        }

        override fun isPhysical(): Boolean {
            return false
        }

        override fun getResolveScope(): GlobalSearchScope {
            return null!!
        }

        override fun getUseScope(): SearchScope {
            return null!!
        }

        override fun getNode(): ASTNode? {
            return null
        }

        override fun isEquivalentTo(psiElement: PsiElement): Boolean {
            return false
        }

        override fun getIcon(@IconFlags i: Int): Icon? {
            return null
        }

        override fun <T> getUserData(tKey: Key<T>): T? {
            return null
        }

        override fun <T> putUserData(tKey: Key<T>, t: T?) {

        }
    }

}