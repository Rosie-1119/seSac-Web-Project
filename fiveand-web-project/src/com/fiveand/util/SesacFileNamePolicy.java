package com.fiveand.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class SesacFileNamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		String name = f.getName();
		String ext = "";
		int dot = name.lastIndexOf(".");
		if (dot != -1) {
			ext = name.substring(dot); 
			//확장자 추출
		} else {
			ext = "";
		}
		String str = "sesac" + UUID.randomUUID();
		File renameFile = new File(f.getParent(), str + ext);
		//무조건 앞에 sesac을 붙이고 랜덤함 16진수 문자열을 넣도록 한다
		return renameFile;
	}
}
