package CameraModel;

public class CameraModel {
    //variable declaration
    private String overlayText;
    private String snapshotDir;
    private String cameraIp;
    private String outputFileName;

    //set and getter methods

    public void setOverlayText(String overlayText) {
        this.overlayText = overlayText;
    }

    public void setSnapshotDir(String snapshotDir) {
        this.snapshotDir = snapshotDir;
    }

    public void setCameraIp(String cameraIp) {
        this.cameraIp = cameraIp;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getOverlayText() {
        return overlayText;
    }

    public String getSnapshotDir() {
        return snapshotDir;
    }

    public String getCameraIp() {
        return cameraIp;
    }

    public String getOutputFileName() {
        return outputFileName;
    }
    //recording function
    public void record(){
        //recording the video
    }
    //snapshot function
    public void snapshot(){
        //button to take a picture
    }
    // function to turn on/off camera
    public void powerButton(){
        // button to turn on camera
    }
}
