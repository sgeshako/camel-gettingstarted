package camel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;

public class GenerateZIP {
	
	private static final String M = "M";
	private static final String F = "F";

	private static final ImmutableMultimap<String, String> PEOPLE = ImmutableMultimap.<String, String>builder()
			.put(F, "Cristina Piccirillo")
			.put(F, "Mariel Aiello")
			.put(F, "Zetta Danner")
			.put(F, "Karma Weidler")
			.put(F, "Shaunna Lefkowitz")
			.put(F, "Ressie Ebbert")
			.put(M, "Brant Hutsell")
			.put(F, "Christinia Feld")
			.put(M, "Roland Boyes")
			.put(F, "Enola Hailey")
			.put(F, "Ivette Kotek")
			.put(M, "Jarrod Ramirez")
			.put(F, "Velda Boatner")
			.put(F, "Jeanne Belknap")
			.put(F, "Christeen Humiston")
			.put(F, "Rossie Blalock")
			.put(M, "Rueben Mcelfresh")
			.put(F, "Suzan Heath")
			.put(M, "Hong Telford")
			.put(F, "Analisa Puthoff")
			.build();
	
	private static final String[] POSTCODES = {
			"EH11",
			"NR16",
			"NE11",
			"LS12",
			"TS23",
			"LE89",
			"TA35",
			"SO32",
			"TN24",
			"PO19",
			"OL14",
			"HP66",
			"WR66",
			"AL10",
			"BD50",
			"CM61",
			"RG12",
			"FY76",
			"GU18",
			"CF64",
	};
	
	private static String generateBirthdate(Random random) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		return sdf.format(new Date(random.nextLong()));
	}

	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		
		for (Entry<String, String> entry : PEOPLE.entries()) {
			sb.append(entry.getKey() + String.format(
					"%1$-19s",
					entry.getValue()) + generateBirthdate(rand) + POSTCODES[rand.nextInt(20)]);
		}
		
		File f = new File("data\\inbox\\file2.txt.gz");
		try {
//			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
//			ZipEntry e = new ZipEntry("thefile.txt");
//			out.putNextEntry(e);
			
			GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(f));
			
			byte[] data = sb.toString().getBytes();
			out.write(data, 0, data.length);
//			out.closeEntry();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}