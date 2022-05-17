package br.pucrio.opus.smells.resources;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import br.pucrio.opus.smells.ast.visitors.TypeDeclarationCollector;

public class SourceFile {

	private transient File file;

	private String fileRelativePath;
	
	private transient CompilationUnit compilationUnit;
	
	private transient List<Type> types;
	
	public SourceFile(File file, CompilationUnit compilationUnit) {
		this.file = file;
		Path cwd = FileSystems.getDefault().getPath("").toAbsolutePath();
		this.fileRelativePath = cwd.relativize(Paths.get(file.getPath())).toString();
		this.compilationUnit = compilationUnit;
		this.searchForTypes();
	}
	
	private void searchForTypes() {
		this.types = new ArrayList<>();
		TypeDeclarationCollector visitor = new TypeDeclarationCollector();
		this.compilationUnit.accept(visitor);
		List<TypeDeclaration> typeDeclarations = visitor.getNodesCollected();
		for (TypeDeclaration typeDeclaration : typeDeclarations) {
			Type type = new Type(this, typeDeclaration);
			this.types.add(type);
		}
	}
	
	public List<Type> getTypes() {
		return types;
	}

	public File getFile() {
		return file;
	}

	public String getFileRelativePath() { return fileRelativePath; }

	public CompilationUnit getCompilationUnit() {
		return compilationUnit;
	}

}
