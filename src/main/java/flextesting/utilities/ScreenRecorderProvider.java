package flextesting.utilities;

import org.apache.log4j.Logger;
import org.monte.media.Format;
import org.monte.media.FormatKeys.*;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderProvider {
	
	private class SpecializedScreenRecorder extends ScreenRecorder {
		 
	    private String name;
	 
	    public SpecializedScreenRecorder(GraphicsConfiguration cfg,
	           Rectangle captureArea, Format fileFormat, Format screenFormat,
	           Format mouseFormat, Format audioFormat, File movieFolder,
	           String name) throws IOException, AWTException {
	         super(cfg, captureArea, fileFormat, screenFormat, mouseFormat,
	                  audioFormat, movieFolder);
	         this.name = name;
	    }
	 
	    @Override
	    protected File createMovieFile(Format fileFormat) throws IOException {
	          if (!movieFolder.exists()) {
	                movieFolder.mkdirs();
	          } else if (!movieFolder.isDirectory()) {
	                throw new IOException("\"" + movieFolder + "\" is not a directory.");
	          }
	                           
	          SimpleDateFormat dateFormat = new SimpleDateFormat(
	                   "yyyy-MM-dd HH.mm.ss");
	                         
	          return new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "."
	                  + Registry.getInstance().getExtension(fileFormat));
	    }
	} 
	
	static Logger log = Logger.getLogger(ScreenRecorderProvider.class);
	private SpecializedScreenRecorder screenRecorder;
	private boolean recordFlag = false;
	public ScreenRecorderProvider() {
		//set the recordFlag
		this.recordFlag = setRecordFlag();
		
	}
	private void constructScreenRecorderAndStartRecording(String fileSubDir, String fileName) throws IOException, AWTException {
		log.info("Constructing the screen recorder...");
		File fileFolder = new File("Videos\\"+fileSubDir);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
					   
		Rectangle captureSize = new Rectangle(0,0, width, height);
					   
		//Create a instance of GraphicsConfiguration to get the Graphics configuration
		//of the Screen. This is needed for ScreenRecorder class.
		GraphicsConfiguration gc = GraphicsEnvironment
									 .getLocalGraphicsEnvironment()
									 .getDefaultScreenDevice()
									 .getDefaultConfiguration();

		this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
			new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
			new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
				  CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
				  DepthKey, 24, FrameRateKey, Rational.valueOf(15),
				  QualityKey, 1.0f,
				  KeyFrameIntervalKey, 15 * 60),
			new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
				  FrameRateKey, Rational.valueOf(30)),
			null, fileFolder, fileName);
		screenRecorder.start();
	}
	public void start(String clientCode, String featureName) throws IOException, AWTException {
		if (recordFlag) {
			constructScreenRecorderAndStartRecording(clientCode, featureName.replaceAll("[^A-Za-z0-9]", " "));
			log.info("Screen recorder constructed and recording starts now...");
		}
	}
	public void stop() throws IOException {
		if (recordFlag) {
			screenRecorder.stop();
			log.info("Recording Stopped");
			List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();
			for(File movie : createdMovieFiles){
				log.info("New video created: " + movie.getAbsolutePath());
			}
		}
	}
	private boolean setRecordFlag() {
//		//this recording method can not record headless or xvfb
//		String record = System.getProperty("record");
//		if (record != null && record.equalsIgnoreCase("True")) {
		if (System.getProperty("driverType").equals("scd")) {
			log.info("Local Recording flag is set to True because Special Chrome Driver is chosen");
			return true; 
		}
		else {
			log.info("Local Recording flag is set to False because Special Chrome Driver is not chosen");
			return false;
		}
	}
}
