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

import com.intellij.injected.editor.DocumentWindow
import com.intellij.injected.editor.VirtualFileWindow
import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.lang.Language
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.Disposable
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.RangeMarker
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable.IconFlags
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.Segment
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.*
import com.intellij.psi.impl.PsiDocumentManagerImpl
import com.intellij.psi.impl.PsiManagerEx
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.PsiElementProcessor
import com.intellij.psi.search.SearchScope
import com.intellij.psi.xml.XmlFile
import com.intellij.testFramework.LightVirtualFile
import com.intellij.util.IncorrectOperationException
import org.jetbrains.android.facet.AndroidFacet
import org.jetbrains.android.resourceManagers.ModuleResourceManagers
import org.jetbrains.annotations.NonNls
import org.jetbrains.kotlin.psi.KtFile
import java.beans.PropertyChangeListener
import javax.swing.Icon

/*
  Reason for these stubs:
  Android Preview checks that the xml file is placed inside "layout-*" directory.
  TODO: Implement some kind of stable api in Android plugin for this
 */
class LayoutPsiFile(private val myPsiFile: XmlFile, val originalFile: KtFile, module: Module) : XmlFile {
    private val myPsiDirectory: PsiDirectory = LayoutPsiDirectory(module)

    private val myViewProvider: FileViewProvider = object : FileViewProvider by myPsiFile.viewProvider {
        override fun getPsi(p0: Language): PsiFile = this@LayoutPsiFile
    }

    private val myVirtualFile: VirtualFile by lazy {
        LayoutLightVirtualFile(myPsiFile.name, myPsiFile.text).also { virtualFile ->
            (myPsiFile.manager as? PsiManagerEx)?.fileManager?.setViewProvider(virtualFile, myViewProvider)
        }
    }

    override fun getParent() = myPsiDirectory
    override fun getDocument() = myPsiFile.document
    override fun getRootTag() = myPsiFile.rootTag
    override fun getVirtualFile(): VirtualFile? = myVirtualFile
    override fun getContainingDirectory() = myPsiDirectory
    override fun getModificationStamp() = myPsiFile.modificationStamp
    override fun getOriginalFile() = this
    override fun getFileType() = myPsiFile.fileType
    override fun getViewProvider() = myViewProvider
    override fun getNode(): FileASTNode? = myPsiFile.node
    override fun getPsiRoots(): Array<PsiFile> = myPsiFile.psiRoots
    override fun subtreeChanged() = myPsiFile.subtreeChanged()
    override fun isDirectory() = myPsiFile.isDirectory
    override fun getName() = myPsiFile.name
    override fun checkSetName(s: String) = myPsiFile.checkSetName(s)
    override fun setName(s: String): PsiElement = myPsiFile.setName(s)
    override fun getProject() = myPsiFile.project
    override fun getLanguage() = myPsiFile.language
    override fun getManager(): PsiManager? = myPsiFile.manager
    override fun getChildren(): Array<PsiElement> = myPsiFile.children
    override fun getFirstChild(): PsiElement? = myPsiFile.firstChild
    override fun getLastChild(): PsiElement? = myPsiFile.lastChild
    override fun getNextSibling(): PsiElement? = myPsiFile.nextSibling
    override fun getPrevSibling(): PsiElement? = myPsiFile.prevSibling
    override fun getContainingFile(): PsiFile? = myPsiFile.containingFile
    override fun getTextRange(): TextRange? = myPsiFile.textRange
    override fun getStartOffsetInParent() = myPsiFile.startOffsetInParent
    override fun getTextLength() = myPsiFile.textLength
    override fun findElementAt(i: Int) = myPsiFile.findElementAt(i)
    override fun findReferenceAt(i: Int) = myPsiFile.findReferenceAt(i)
    override fun getTextOffset() = myPsiFile.textOffset
    override fun getText(): String? = myPsiFile.text
    override fun textToCharArray() = myPsiFile.textToCharArray()
    override fun getNavigationElement(): PsiElement? = myPsiFile.navigationElement
    override fun getOriginalElement(): PsiElement? = myPsiFile.originalElement
    override fun textMatches(charSequence: CharSequence) = myPsiFile.textMatches(charSequence)
    override fun textMatches(psiElement: PsiElement) = myPsiFile.textMatches(psiElement)
    override fun textContains(c: Char) = myPsiFile.textContains(c)
    override fun accept(psiElementVisitor: PsiElementVisitor) = myPsiFile.accept(psiElementVisitor)
    override fun acceptChildren(psiElementVisitor: PsiElementVisitor) = myPsiFile.acceptChildren(psiElementVisitor)
    override fun copy(): PsiElement? = myPsiFile.copy()
    override fun add(psiElement: PsiElement): PsiElement? = myPsiFile.add(psiElement)

    override fun processChildren(psiFileSystemItemPsiElementProcessor: PsiElementProcessor<PsiFileSystemItem>?): Boolean {
        return myPsiFile.processChildren(psiFileSystemItemPsiElementProcessor)
    }

    override fun addBefore(psiElement: PsiElement, psiElement2: PsiElement?): PsiElement? =
            myPsiFile.addBefore(psiElement, psiElement2)

    override fun addAfter(psiElement: PsiElement, psiElement2: PsiElement?): PsiElement? =
            myPsiFile.addAfter(psiElement, psiElement2)

    override fun checkAdd(psiElement: PsiElement) = myPsiFile.checkAdd(psiElement)

    override fun addRange(psiElement: PsiElement, psiElement2: PsiElement): PsiElement? {
        return myPsiFile.addRange(psiElement, psiElement2)
    }

    override fun addRangeBefore(psiElement: PsiElement, psiElement2: PsiElement, psiElement3: PsiElement): PsiElement? {
        return myPsiFile.addRangeBefore(psiElement, psiElement2, psiElement3)
    }

    override fun addRangeAfter(psiElement: PsiElement, psiElement2: PsiElement, psiElement3: PsiElement): PsiElement? {
        return myPsiFile.addRangeAfter(psiElement, psiElement2, psiElement3)
    }

    override fun delete() = myPsiFile.delete()

    override fun checkDelete() = myPsiFile.checkDelete()

    override fun deleteChildRange(psiElement: PsiElement, psiElement2: PsiElement)
            = myPsiFile.deleteChildRange(psiElement, psiElement2)

    override fun replace(psiElement: PsiElement): PsiElement? = myPsiFile.replace(psiElement)
    override fun isValid() = myPsiFile.isValid
    override fun isWritable() = myPsiFile.isWritable
    override fun getReference() = myPsiFile.reference
    override fun getReferences(): Array<PsiReference> = myPsiFile.references
    override fun <T> getCopyableUserData(tKey: Key<T>) = myPsiFile.getCopyableUserData(tKey)
    override fun <T> putCopyableUserData(tKey: Key<T>, t: T?) = myPsiFile.putCopyableUserData(tKey, t)

    override fun processDeclarations(
            psiScopeProcessor: PsiScopeProcessor,
            resolveState: ResolveState,
            psiElement: PsiElement?,
            psiElement2: PsiElement
    ): Boolean {
        return myPsiFile.processDeclarations(psiScopeProcessor, resolveState, psiElement, psiElement2)
    }

    override fun getContext() = myPsiFile.context

    override fun isPhysical() = myPsiFile.isPhysical

    override fun getResolveScope() = myPsiFile.resolveScope

    override fun getUseScope() = myPsiFile.useScope

    override fun toString() = myPsiFile.toString()
    override fun isEquivalentTo(psiElement: PsiElement) = myPsiFile.isEquivalentTo(psiElement)
    override fun <T> getUserData(tKey: Key<T>) = myPsiFile.getUserData(tKey)
    override fun <T> putUserData(tKey: Key<T>, t: T?) = myPsiFile.putUserData(tKey, t)
    override fun getIcon(i: Int): Icon = myPsiFile.getIcon(i)
    override fun getPresentation() = myPsiFile.presentation
    override fun navigate(b: Boolean) = myPsiFile.navigate(b)
    override fun canNavigate() = myPsiFile.canNavigate()
    override fun canNavigateToSource() = myPsiFile.canNavigateToSource()
    override fun getFileResolveScope() = myPsiFile.fileResolveScope
    override fun ignoreReferencedElementAccessibility() = myPsiFile.ignoreReferencedElementAccessibility()

    override fun processElements(psiElementProcessor: PsiElementProcessor<PsiElement>, psiElement: PsiElement): Boolean {
        return myPsiFile.processElements(psiElementProcessor, psiElement)
    }

    private class LayoutPsiDirectory(val module: Module) : PsiDirectory {
        private val parentDir by lazy {
            val facet = AndroidFacet.getInstance(module) ?: return@lazy null
            val dir = ModuleResourceManagers.getInstance(facet).localResourceManager.resourceDirs
                    .firstOrNull() ?: return@lazy null
            PsiManager.getInstance(module.project).findDirectory(dir)
        }

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

        override fun getParentDirectory(): PsiDirectory? = parentDir

        override fun getParent() = parentDir

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

        override fun processDeclarations(
                psiScopeProcessor: PsiScopeProcessor,
                resolveState: ResolveState,
                psiElement: PsiElement?,
                psiElement2: PsiElement
        ): Boolean {
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

    inner class LayoutLightVirtualFile(name: String, text: String) : LightVirtualFile(name, text), VirtualFileWindow {
        /*
         * This hack is needed to force PsiDocumentManager return our LayoutPsiFile for LayoutLightVirtualFile
         */
        override fun getDocumentWindow(): DocumentWindow {
            val documentManager = PsiDocumentManager.getInstance(project)
            val documentWindowStub =  object : UserDataHolderBase(), DocumentWindow {
                override fun hostToInjectedUnescaped(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun isOneLine(): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun removeDocumentListener(p0: DocumentListener) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun deleteString(p0: Int, p1: Int) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getTextLength(): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getHostRanges(): Array<Segment> {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getText(): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getText(p0: TextRange): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getLineStartOffset(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun createRangeMarker(p0: Int, p1: Int): RangeMarker {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun createRangeMarker(p0: Int, p1: Int, p2: Boolean): RangeMarker {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun createRangeMarker(p0: TextRange): RangeMarker {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun insertString(p0: Int, p1: CharSequence) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun setText(p0: CharSequence) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun startGuardedBlockChecking() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getHostRange(p0: Int): TextRange? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getChars(): CharArray {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getLineCount(): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun stopGuardedBlockChecking() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun areRangesEqual(p0: DocumentWindow): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun isValid(): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun removeGuardedBlock(p0: RangeMarker) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getLineSeparatorLength(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun injectedToHostLine(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun addPropertyChangeListener(p0: PropertyChangeListener) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun createGuardedBlock(p0: Int, p1: Int): RangeMarker {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun replaceString(p0: Int, p1: Int, p2: CharSequence) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getModificationStamp(): Long {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun setReadOnly(p0: Boolean) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun intersectWithEditable(p0: TextRange): TextRange? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun fireReadOnlyModificationAttempt() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getLineNumber(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun setCyclicBufferSize(p0: Int) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun hostToInjected(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getImmutableCharSequence(): CharSequence {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getOffsetGuard(p0: Int): RangeMarker? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun isWritable(): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getLineEndOffset(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getCharsSequence(): CharSequence {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getDelegate(): Document {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun containsRange(p0: Int, p1: Int): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun addDocumentListener(p0: DocumentListener) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun addDocumentListener(p0: DocumentListener, p1: Disposable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun removePropertyChangeListener(p0: PropertyChangeListener) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getRangeGuard(p0: Int, p1: Int): RangeMarker? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun injectedToHost(p0: Int): Int {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun injectedToHost(p0: TextRange): TextRange {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
            (documentManager as PsiDocumentManagerImpl).associatePsi(documentWindowStub, this@LayoutPsiFile)
            return documentWindowStub
        }

        override fun getDelegate(): VirtualFile = this@LayoutPsiFile.originalFile.virtualFile

        override fun getParent() = object : LightVirtualFile("layout") {
            override fun isDirectory() = true
        }
    }
}