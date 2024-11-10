//Base Class
abstract class SmartDevice{
   private String deviceName;
     private String status;
    public SmartDevice(String deviceName){
        this.deviceName=deviceName;
        this.status="Off";
    }
    public String getDeviceName(){
        return deviceName;
    }
    public String getStatus(){
        return status;
    }
    public void turnOn(){
        status="ON";
        System.out.println(deviceName + "is turned ON.");
    }
    public void turnOff(){
        status="Off";
        System.out.println(deviceName + "is turned Off");
    }
    public abstract void scheduleAutomation();
}
// BatteryPowered interface 
interface BatteryPowered {
     void checkBattery(); 
}
// Sub Class
class Light extends SmartDevice{
    public Light(String DeviceName){
        super(DeviceName);
    }
    public void turnOn(){
        System.out.println("Adjusting Brigtness for:" + getDeviceName());
    }
    public void scheduleAutomation(){
        System.out.println("Schedule Automation for:" + getDeviceName());
    }
}
// Thermostat class
 class Thermostat extends SmartDevice implements BatteryPowered { 
    public Thermostat(String deviceName) { 
        super(deviceName); 
    }
     public void turnOn() {
         super.turnOn();
          System.out.println("Setting temperature for " + getDeviceName()); 
        } @Override
         public void scheduleAutomation() { 
            System.out.println("Scheduling automation for " + getDeviceName());
         } 
         public void checkBattery() {
             System.out.println("Checking battery level for " + getDeviceName()); 
            }
 } // SecurityCamera class
 class SecurityCamera extends SmartDevice implements BatteryPowered {
     public SecurityCamera(String deviceName) { super(deviceName);
     }
     public void turnOn() { 
    super.turnOn(); System.out.println("Starting video recording for " + getDeviceName());
 }
  public void scheduleAutomation() {
     System.out.println("Scheduling automation for " + getDeviceName());
     } public void checkBattery() {
         System.out.println("Checking battery level for " + getDeviceName());
         } 
}
public class SmartHome {
    public static void main(String[] args) {
        SmartDevice light = new Light("Living Room Light"); 
        SmartDevice thermostat = new Thermostat("Hallway Thermostat");
         SmartDevice camera = new SecurityCamera("Front Door Camera");
          light.turnOn();
           light.scheduleAutomation();
            thermostat.turnOn(); 
          ((BatteryPowered) thermostat).checkBattery();
           thermostat.scheduleAutomation();
             camera.turnOn(); 
           ((BatteryPowered) camera).checkBattery(); 
           camera.scheduleAutomation();
    }
}
