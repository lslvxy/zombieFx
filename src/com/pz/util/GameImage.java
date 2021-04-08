package com.pz.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;

import com.thoughtworks.xstream.XStream;

public class GameImage {
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;

	@SuppressWarnings("unchecked")
	public static Map<String, Image> loadImage(File imgXml) {
		XStream xstream = new XStream();
		xstream.alias("image", ZombieImage.class);
		Map<String, Image> map = new HashMap<String, Image>();
		try {
			String xml = FileUtil.readFile(imgXml);

			List<ZombieImage> imageList = (ArrayList<ZombieImage>) xstream
					.fromXML(xml);
			for (ZombieImage img : imageList) {
				map.put(img.getName(), new Image("file:" + img.getPath()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
