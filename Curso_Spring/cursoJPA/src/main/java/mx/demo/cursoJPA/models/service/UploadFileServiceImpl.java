package mx.demo.cursoJPA.models.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final static String UPLOADS = "uploads";

	@Override
	public Resource load(String fileName) throws MalformedURLException {

		Path pathFoto = getPath(fileName);
		Resource recurso = null;

		recurso = new UrlResource(pathFoto.toUri());
		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("No se puede cargar la imagen");
		}

		return recurso;
	}

	@Override
	public String copy(MultipartFile file)  throws IOException{

		String uniqueFileName = UUID.randomUUID().toString() + file.getOriginalFilename();

//		Path directorioRecursos = Paths.get("C://opt"); //Path se usa cuando vamos a usar la dirección del WAR/JAR como base (todo se crea en el)
		Path rootPath = getPath(uniqueFileName);
//		String rootPath = "C://opt//uploads"; //Usado cuando el proyecto cuenta con un fileSystem
//				directorioRecursos.toFile().getAbsolutePath();

//		byte[] bytes = foto.getBytes();
//		Path rutaCompleta = Paths.get(rootPath + "//"+ uniqueFileName);
//		Files.write(rutaCompleta, bytes);
		Files.copy(file.getInputStream(), rootPath); // Reemplaza las 3 lineas anteriores

		return uniqueFileName;
	}

	@Override
	public boolean delete(String fileName) {
		//Para eliminar foto
		
		File archivo = getPath(fileName).toAbsolutePath().toFile();
		
		if (archivo.exists() && archivo.canRead()) {
			if(archivo.delete()) {
//				flash.addFlashAttribute("info", "el usuario y su foto fue eliminada");
			}
		}
		return false;
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(Paths.get(UPLOADS).toFile());
	}

	@Override
	public void init() throws IOException {
		Files.createDirectory(Paths.get(UPLOADS));
	}

	public Path getPath(String filename) {
		return Paths.get(UPLOADS).resolve(filename).toAbsolutePath();
	}
}
