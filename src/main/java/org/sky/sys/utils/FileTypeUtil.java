package org.sky.sys.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 根据二进制文件流获取文件类型
 * 
 * @author Hou
 *
 */
public class FileTypeUtil {

	/**
	 * 文件头类型
	 * 
	 * @author Hou
	 *
	 *         常见文件头类型
	 * 
	 *  <pre>
    FFD8FFFE00, .JPEG;.JPE;.JPG, "JPG Graphic File"
    FFD8FFE000, .JPEG;.JPE;.JPG, "JPG Graphic File"
    474946383961, .gif, "GIF 89A"
    474946383761, .gif, "GIF 87A"
    424D, .bmp, "Windows Bitmap"
    4D5A, .exe;.com;.386;.ax;.acm;.sys;.dll;.drv;.flt;.fon;.ocx;.scr;.lrc;.vxd;<br>.cpl;.x32, "Executable File" 
    504B0304, .zip, "Zip Compressed"
    3A42617365, .cnt, ""
    D0CF11E0A1B11AE1, .doc;.xls;.xlt;.ppt;.apr, "MS Compound Document v1 or Lotus Approach APR file"
    0100000058000000, .emf, ""
    03000000C466C456, .evt, ""
    3F5F0300, .gid;.hlp;.lhp, "Windows Help File"
    1F8B08, .gz, "GZ Compressed File"
    28546869732066696C65, .hqx, ""
    0000010000, .ico, "Icon File"
    4C000000011402, .lnk, "Windows Link File"
    25504446, .pdf, "Adobe PDF File"
    5245474544495434, .reg, ""
    7B5C727466, .rtf, "Rich Text Format File"
    lh, .lzh, "Lz compression file"
    MThd, .mid, ""
    0A050108, .pcx, ""
    25215053, .eps, "Adobe EPS File"
    2112, .ain, "AIN Archive File"
    1A02, .arc, "ARC/PKPAK Compressed 1"
    1A03, .arc, "ARC/PKPAK Compressed 2"
    1A04, .arc, "ARC/PKPAK Compressed 3"
    1A08, .arc, "ARC/PKPAK Compressed 4"
    1A09, .arc, "ARC/PKPAK Compressed 5"
    60EA, .arj, "ARJ Compressed"
    41564920, .avi, "Audio Video Interleave (AVI)"
    425A68, .bz;.bz2, "Bzip Archive"
    49536328, .cab, "Cabinet File"
    4C01, .obj, "Compiled Object Module"
    303730373037, .tar;.cpio, "CPIO Archive File"
    4352555348, .cru;.crush, "CRUSH Archive File"
    3ADE68B1, .dcx, "DCX Graphic File"
    1F8B, .gz;.tar;.tgz, "Gzip Archive File"
    91334846, .hap, "HAP Archive File"
    3C68746D6C3E, .htm;.html, "HyperText Markup Language 1"
    3C48544D4C3E, .htm;.html, "HyperText Markup Language 2"
    3C21444F4354, .htm;.html, "HyperText Markup Language 3"
    100, .ico, "ICON File"
    5F27A889, .jar, "JAR Archive File"
    2D6C68352D, .lha, "LHA Compressed"
    20006040600, .wk1;.wks, "Lotus 123 v1 Worksheet"
    00001A0007800100, .fm3, "Lotus 123 v3 FMT file"
    00001A0000100400, .wk3, "Lotus 123 v3 Worksheet"
    20006800200, .fmt, "Lotus 123 v4 FMT file"
    00001A0002100400, .wk4, "Lotus 123 v5"
    5B7665725D, .ami, "Lotus Ami Pro"
    300000041505052, .adx, "Lotus Approach ADX file"
    1A0000030000, .nsf;.ntf, "Lotus Notes Database/Template"
    4D47582069747064, .ds4, "Micrografix Designer 4"
    4D534346, .cab, "Microsoft CAB File Format"
    4D546864, .mid, "Midi Audio File"
    000001B3, .mpg;.mpeg, "MPEG Movie"
    0902060000001000B9045C00, .xls, "MS Excel v2"
    0904060000001000F6055C00, .xls, "MS Excel v4"
    7FFE340A, .doc, "MS Word"
    1234567890FF, .doc, "MS Word 6.0"
    31BE000000AB0000, .doc, "MS Word for DOS 6.0"
    1A00000300001100, .nsf, "Notes Database"
    7E424B00, .psp, "PaintShop Pro Image File"
    504B0304, .zip, "PKZIP Compressed"
    89504E470D0A, .png, "PNG Image File"
    6D646174, .mov, "QuickTime Movie"
    6D646174, .qt, "Quicktime Movie File"
    52617221, .rar, "RAR Archive File"
    2E7261FD, .ra;.ram, "Real Audio File"
    EDABEEDB, .rpm, "RPM Archive File"
    2E736E64, .au, "SoundMachine Audio File"
    53495421, .sit, "Stuffit v1 Archive File"
    53747566664974, .sit, "Stuffit v5 Archive File"
    1F9D, .z, "TAR Compressed Archive File"
    49492A, .tif;.tiff, "TIFF (Intel)"
    4D4D2A, .tif;.tiff, "TIFF (Motorola)"
    554641, .ufa, "UFA Archive File"
    57415645666D74, .wav, "Wave Files"
    D7CDC69A, .wmf, "Windows Meta File"
    4C000000, .lnk, "Windows Shortcut (Link File)"
    504B3030504B0304, .zip, "WINZIP Compressed"
    FF575047, .wpg, "WordPerfect Graphics"
    FF575043, .wp, "WordPerfect v5 or v6"
    3C3F786D6C, .xml, "XML Document"
    FFFE3C0052004F004F0054005300540055004200, .xml, "XML Document (ROOTSTUB)"
    3C21454E54495459, .dtd, "XML DTD"
    5A4F4F20, .zoo, "ZOO Archive File"
	 * </pre>
	 * 
	 */
	public enum FileType {
		/**
		 * JEPG.
		 */
		JPEG("FFD8FF"),

		/**
		 * PNG.
		 */
		PNG("89504E47"),

		/**
		 * GIF.
		 */
		GIF("47494638"),

		/**
		 * TIFF.
		 */
		TIFF("49492A00"),

		/**
		 * Windows Bitmap.
		 */
		BMP("424D"),

		/**
		 * CAD.
		 */
		DWG("41433130"),

		/**
		 * Adobe Photoshop.
		 */
		PSD("38425053"),

		/**
		 * Rich Text Format.
		 */
		RTF("7B5C727466"),

		/**
		 * XML.
		 */
		XML("3C3F786D6C"),

		/**
		 * HTML.
		 */
		HTML("68746D6C3E"),
		/**
		 * CSS.
		 */
		CSS("48544D4C207B0D0A0942"),
		/**
		 * JS.
		 */
		JS("696B2E71623D696B2E71"),
		/**
		 * Email [thorough only].
		 */
		EML("44656C69766572792D646174653A"),

		/**
		 * Outlook Express.
		 */
		DBX("CFAD12FEC5FD746F"),

		/**
		 * Outlook (pst).
		 */
		PST("2142444E"),

		/**
		 * MS Word/Excel.
		 */
		XLS_DOC("D0CF11E0"), XLSX_DOCX("504B030414000600080000002100"),
		/**
		 * Visio
		 */
		VSD("d0cf11e0a1b11ae10000"),
		/**
		 * MS Access.
		 */
		MDB("5374616E64617264204A"),
		/**
		 * WPS文字wps、表格et、演示dps都是一样的
		 */
		WPS("d0cf11e0a1b11ae10000"),
		/**
		 * torrent
		 */
		TORRENT("6431303A637265617465"),
		/**
		 * WordPerfect.
		 */
		WPD("FF575043"),

		/**
		 * Postscript.
		 */
		EPS("252150532D41646F6265"),

		/**
		 * Adobe Acrobat.
		 */
		PDF("255044462D312E"),

		/**
		 * Quicken.
		 */
		QDF("AC9EBD8F"),

		/**
		 * Windows Password.
		 */
		PWL("E3828596"),

		/**
		 * ZIP Archive.
		 */
		ZIP("504B0304"),

		/**
		 * RAR Archive.
		 */
		RAR("52617221"),
		/**
		 * JSP Archive.
		 */
		JSP("3C2540207061676520"),
		/**
		 * JAVA Archive.
		 */
		JAVA("7061636B61676520"),
		/**
		 * CLASS Archive.
		 */
		CLASS("CAFEBABE0000002E00"),
		/**
		 * JAR Archive.
		 */
		JAR("504B03040A000000"),
		/**
		 * MF Archive.
		 */
		MF("4D616E69666573742D56"),
		/**
		 * EXE Archive.
		 */
		EXE("4D5A9000030000000400"),
		/**
		 * CHM Archive.
		 */
		CHM("49545346030000006000"),
		/*
		 * INI("235468697320636F6E66"), SQL("494E5345525420494E54"), BAT(
		 * "406563686F206f66660D"), GZ("1F8B0800000000000000"), PROPERTIES(
		 * "6C6F67346A2E726F6F74"), MXP( "04000000010000001300"),
		 */
		/**
		 * Wave.
		 */
		WAV("57415645"),

		/**
		 * AVI.
		 */
		AVI("41564920"),

		/**
		 * Real Audio.
		 */
		RAM("2E7261FD"),

		/**
		 * Real Media.
		 */
		RM("2E524D46"),

		/**
		 * MPEG (mpg).
		 */
		MPG("000001BA"),

		/**
		 * Quicktime.
		 */
		MOV("6D6F6F76"),

		/**
		 * Windows Media.
		 */
		ASF("3026B2758E66CF11"),

		/**
		 * MIDI.
		 */
		MID("4D546864"),
		/**
		 * MP4.
		 */
		MP4("00000020667479706d70"),
		/**
		 * MP3.
		 */
		MP3("49443303000000002176"),
		/**
		 * FLV.
		 */
		FLV("464C5601050000000900");

		private String value = "";

		/**
		 * 
		 * @param type
		 */
		private FileType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	/**
	 * 将文件头转换成16进制字符串 *
	 * 
	 * @param 原生byte
	 * @return 16进制字符串
	 */
	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 得到文件头
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 文件头
	 * @throws IOException
	 */
	private static String getFileContent(String filePath) throws IOException {
		byte[] b = new byte[28];
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
			inputStream.read(b, 0, 28);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}
		return bytesToHexString(b);
	}

	/**
	 * * 判断文件类型
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 文件类型
	 */
	public static FileType getType(byte[] by) throws IOException {
		String fileHead = bytesToHexString(by);
		if (fileHead == null || fileHead.length() == 0) {
			return null;
		}
		fileHead = fileHead.toUpperCase();
		FileType[] fileTypes = FileType.values();
		for (FileType type : fileTypes) {
			if (fileHead.startsWith(type.getValue())) {
				return type;
			}
		}
		return null;
	}
	
	/**
	 * * 判断文件类型
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 文件类型
	 */
	public static FileType getType(String filePath) throws IOException {
		String fileHead = getFileContent(filePath);
		if (fileHead == null || fileHead.length() == 0) {
			return null;
		}
		fileHead = fileHead.toUpperCase();
		FileType[] fileTypes = FileType.values();
		for (FileType type : fileTypes) {
			if (fileHead.startsWith(type.getValue())) {
				return type;
			}
		}
		return null;
	}

	public static void main(String args[]) throws Exception {
		System.out.println(FileTypeUtil.getType("F:/zp/1.png"));
	}

}
