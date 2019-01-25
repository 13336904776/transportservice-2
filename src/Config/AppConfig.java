package Config;

//�����ַ�˿�������Ϣ��
public class AppConfig {
    //  ����˿�
    public static final int PORT = 8080;

    //  �����ȡ С���ٶ� ��ַ
    public static final String GET_CAR_SPEED = "GetCarSpeed.do";
    //  �����ȡ С���˻���� ��ַ
    public static final String GET_CAR_BALANCE = "GetCarAccountBalance.do";
    //  �����ȡ ͣ�������� ��ַ
    public static final String GET_PARK_RATE = "GetParkRate.do";
    //  �����ȡ ���̵���Ϣ ��ַ
    public static final String GET_LIGHT_MSG = "GetTrafficLightConfigAction.do";
    //  �����ȡ ͣ�������г�λ��Ϣ ��ַ
    public static final String GET_FREE_LOCATION = "GetParkFree.do";
    //  �����ȡ ���д�������Ϣ ��ַ
    public static final String GET_ALL_SENSOR = "GetAllSense.do";
    //  �����ȡ ���մ�������ֵ��Ϣ ��ַ
    public static final String GET_SENSOR_LIGHT = "GetLightSenseValue.do";
    //  �����ȡ ����վ̨��Ϣ ��ַ
    public static final String GET_BUS_STATION_INFO = "GetBusStationInfo.do";
    //  �����ȡ ��·ӵ��״̬ ��ַ
    public static final String GET_ROAD_STATION_INFO = "GetRoadStatus.do";

    //  �������� С������ ��ַ
    public static final String SET_CAR_ACTION = "SetCarMove.do";
    //  �������� С���˻���� ��ַ
    public static final String SET_CAR_BALANCE = "SetCarAccountRecharge.do";
    //  �������� С������ ��ַ
    public static final String SET_PARK_RATE = "SetParkRate.do";

    //  json �� С�� id
    public static final String KEY_CAR_ID = "CarId";
    //  json �� С���ٶ�
    public static final String KEY_CAR_SPEED = "CarSpeed";
    //  json �� С������
    public static final String KEY_CAR_ACTION = "CarAction";
    //  json �� С���˻����
    public static final String KEY_CAR_BALANCE = "Balance";

    //  json �� С����ֵ��ͣ�������ʽ��
    public static final String KEY_MONEY = "Money";
    //  json �� ͣ������������
    public static final String KEY_RATE_TYPE = "RateType";
    //  json �� ͣ�������г�λ id
    public static final String KEY_PARK_FREE_ID = "ParkFreeId";

    //  json �� ���̵� id
    public static final String KEY_TRAFFIC_LIGHT_ID = "TrafficLightId";
    //  json �� �Ƶ�ʱ��
    public static final String KEY_LIGHT_YELLOW = "YellowTime";
    //  json �� �̵�ʱ��
    public static final String KEY_LIGHT_GREEN = "GreenTime";
    //  json �� ���ʱ��
    public static final String KEY_LIGHT_RED = "RedTime";

    //  json �� ���մ�������ֵ down
    public static final String KEY_LIGHT_DOWN = "Down";
    //  json �� ���մ�������ֵ up
    public static final String KEY_LIGHT_UP = "Up";

    //  json �� ��������Ϣ pm2.5
    public static final String KEY_SENSOR_PM = "pm2.5";
    //  json �� ��������Ϣ co2
    public static final String KEY_SENSOR_CO2 = "co2";
    //  json �� ��������Ϣ ����ǿ��
    public static final String KEY_SENSOR_LIGHT = "LightIntensity";
    //  json �� ��������Ϣ �¶�
    public static final String KEY_SENSOR_TEMP = "temperature";
    //  json �� ��������Ϣ ʪ��
    public static final String KEY_SENSOR_HUMI = "humidity";

    //  json �� ������ id
    public static final String KEY_BUS_ID = "BusId";
    //  json �� ����վ̨ id
    public static final String KEY_BUS_STATION_ID = "BusStationId";
    //  json �� �������빫��վ̨����
    public static final String KEY_DISTANCE = "Distance";

    //  json �� ��· id
    public static final String KEY_ROAD_ID = "RoadId";
    //  json �� ��·ӵ��״̬
    public static final String KEY_STATUS = "Status";
}
