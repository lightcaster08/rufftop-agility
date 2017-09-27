package data;

import java.util.Arrays;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public class Data {
	private String course;
	private String status = "Initializing";
	public Data(String a, boolean vb) {
		this.course = a;
		this.verbose = vb;
	}	
	
	public String getCourse() {
		return course;
	}
	
	public int lapsBeforeBreak, totalLaps;
	public boolean verbose;
	private int failsafe = 0, nrg = 65, cameraX, cameraY;
	public final int MARK = 11849, LAW = 563, FOOD = 7946,
			STAM = 12631, STAM3 = 12627, STAM2 = 12629, STAM4 = 12625, VIAL = 229;
	private int failsaferu;
	

	// DRAYNOR
	public Area dstart = new Area(3103, 3278, 3104, 3280);
	Position d1 = new Position(3102, 3279, 3);
	Position d2 = new Position(3099, 3277, 3);
	Position d3 = new Position(3090, 3276, 3);
	Position d4 = new Position(3091, 3276, 3);
	Position d5 = new Position(3092, 3266, 3);
	Position d6 = new Position(3089, 3265, 3);
	Position d7 = new Position(3088, 3261, 3);
	Position d8 = new Position(3088, 3257, 3);
	Position d9 = new Position(3088, 3255, 3);
	Position d10 = new Position(3094, 3255, 3);
	Position d11 = new Position(3096, 3256, 3);
	Position d12 = new Position(3101, 3261, 3);
	Position d13 = new Position(3103, 3261, 0);
	public Position[] dArrayEnd = {d1, d3, d5, d7, d9, d11, d13};
	public Position[] dArrayStart = {d2, d4, d6, d8, d10, d12};
	public int[] dObjectArray = {10074, 10075, 10077, 10084, 10085, 10086};
	public String[] dActionArray = {"Cross", "Cross", "Balance", 
			"Jump-up", "Jump", "Climb-down"};
	
	// AL-KHARID
	public Area astart = new Area(3274, 3195, 3272, 3196);
	Position a1 = new Position(3273, 3192, 3);
	Position a2 = new Position(3272, 3182, 3);
	Position a3 = new Position(3272, 3172, 3);
	Position a4 = new Position(3266, 3166, 3);
	Position a5 = new Position(3284, 3166, 3);
	Position a6 = new Position(3301, 3163, 3);
	Position a7 = new Position(3315, 3163, 1);
	Position a8 = new Position(3318, 3165, 1);
	Position a9 = new Position(3317, 3174, 2);
	Position a10 = new Position(3316, 3179, 2);
	Position a11 = new Position(3316, 3180, 3);
	Position a12 = new Position(3314, 3186, 3);
	Position a13 = new Position(3302, 3187, 3);
	Position a14 = new Position(3301, 3192, 3);
	Position a15 = new Position(3299, 3194, 0);
	public Position[] aArrayEnd = {a1, a3, a5, a7, a9, a11, a13, a15};
	public Position[] aArrayStart = {a2, a4, a6, a8, a10, a12, a14};
	public int[] aObjectArray = {10284, 10355, 10356, 10357, 10094, 10583, 10352};
	public String[] aActionArray = {"Cross", "Swing-across", "Teeth-grip",
			"Swing-across", "Climb", "Cross", "Jump"};
	
	
	// VARROCK
	public Area vstart = new Area(3221, 3415, 3222, 3413);
	Position v1 = new Position(3219, 3414, 3);
	Position v2 = new Position(3214, 3414, 3);
	Position v3 = new Position(3208, 3414, 3);
	Position v4 = new Position(3201, 3416, 3);
	Position v5 = new Position(3197, 3416, 1);
	Position v6 = new Position(3194, 3416, 1);
	Position v7 = new Position(3192, 3406, 3);
	Position v8 = new Position(3193, 3402, 3);
	Position v9 = new Position(3193, 3398, 3);
	Position v10 = new Position(3208, 3398, 3);
	Position v11 = new Position(3218, 3399, 3);
	Position v12 = new Position(3232, 3402, 3);
	Position v13 = new Position(3236, 3403, 3);
	Position v14 = new Position(3238, 3408, 3);
	Position v15 = new Position(3236, 3410, 3);
	Position v16 = new Position(3237, 3415, 3);
	Position v17 = new Position(3236, 3417, 0);
	public Position[] vArrayEnd = {v1, v3, v5, v7, v9, v11, v13, v15, v17};
	public Position[] vArrayStart = {v2, v4, v6, v8, v10, v12, v14, v16};
	public int[] vObjectArray = {10587, 10642, 10777, 10778, 10779, 10780, 10781, 10817};
	public String[] vActionArray = {"Cross", "Leap", "Balance", "Leap", 
			"Leap", "Leap", "Hurdle", "Jump-off"};

	// CANIFIS
	public Area cstart = new Area(3507, 3488, 3511, 3485);
	Position c1 = new Position(3506, 3492, 2);
	Position c2 = new Position(3505, 3497, 2);
	Position c3 = new Position(3502, 3504, 2);
	Position c4 = new Position(3498, 3504, 2);
	Position c5 = new Position(3492, 3504, 2);
	Position c6 = new Position(3487, 3499, 2);
	Position c7 = new Position(3479, 3499, 3);
	Position c8 = new Position(3477, 3492, 3);
	Position c9 = new Position(3478, 3486, 2);
	Position c10 = new Position(3480, 3484, 2);
	Position c11 = new Position(3489, 3476, 3);
	Position c12 = new Position(3502, 3476, 3);
	Position c13 = new Position(3510, 3476, 2);
	Position c14 = new Position(3510, 3482, 2);
	Position c15 = new Position(3510, 3485, 0);
	public Position[] cArrayEnd = {c1, c3, c5, c7, c9, c11, c13, c15};
	public Position[] cArrayStart = {c2, c4, c6, c8, c10, c12, c14};
	public int[] cObjectArray = {10820, 10821, 10828, 10822, 10831, 10823, 10832};
	public String[] cActionArray = {"Jump", "Jump", "Jump", "Jump", 
			"Vault", "Jump", "Jump"};
	
	// Falador
	public Area fstart = new Area(3035, 3341, 3037, 3340);
	Position f1 = new Position(3036, 3342, 3);
	Position f2 = new Position(3039, 3343, 3);
	Position f3 = new Position(3047, 3344, 3);
	Position f4 = new Position(3050, 3349, 3);
	Position f5 = new Position(3050, 3357, 3);
	Position f6 = new Position(3048, 3358, 3);
	Position f7 = new Position(3048, 3361, 3);
	Position f8 = new Position(3045, 3361, 3);
	Position f9 = new Position(3041, 3361, 3);
	Position f10 = new Position(3035, 3361, 3);
	Position f11 = new Position(3028, 3354, 3);
	Position f12 = new Position(3027, 3353, 3);
	Position f13 = new Position(3020, 3353, 3);
	Position f14 = new Position(3018, 3353, 3);
	Position f15 = new Position(3018, 3349, 3);
	Position f16 = new Position(3017, 3345, 3);
	Position f17 = new Position(3014, 3346, 3);
	Position f18 = new Position(3012, 3344, 3);
	Position f19 = new Position(3013, 3342, 3);
	Position f20 = new Position(3013, 3335, 3);
	Position f21 = new Position(3013, 3333, 3);
	Position f22 = new Position(3016, 3333, 3);
	Position f23 = new Position(3019, 3333, 3);
	Position f24 = new Position(3022, 3333, 3);
	Position f25 = new Position(3029, 3333, 0);
	public Position[] fArrayEnd = {f1, f3, f5, f7, f9, f11, f13, f15, f17, f19, f21, f23, f25};
	public Position[] fArrayStart = {f2, f4, f6, f8, f10, f12, f14, f16, f18, f20, f22, f24};
	public int[] fObjectArray = {10834, 10836, 11161, 11360, 11361, 
			11364, 11365, 11366, 11367, 11368, 11370, 11371};
	public String[] fActionArray = {"Cross", "Cross", "Jump", 
			"Jump", "Cross", "Cross", "Jump", "Jump", "Jump", "Jump",
			"Jump", "Jump"};
	
	
	
	// SEERS
	public Area sstart = new Area(2728, 3488, 2730, 3487);
	public Area send = new Area(2704, 3464, 2708, 3462);
	public Area stp = new Area(2720, 3489, 2730, 3480);
	Position s1 = new Position(2729, 3491, 3);
	Position s2 = new Position(2721, 3494, 3);
	Position s3 = new Position(2713, 3494, 2);
	Position s4 = new Position(2710, 3490, 2);
	Position s5 = new Position(2710, 3480, 2);
	Position s6 = new Position(2710, 3477, 2);
	Position s7 = new Position(2710, 3472, 3);
	Position s8 = new Position(2702, 3470, 3);
	Position s9 = new Position(2702, 3465, 2);
	Position s10 = new Position(2702, 3464, 2);
	Position s11 = new Position(2704, 3464, 0);
	public Position[] sArrayEnd = {s1, s3, s5, s7, s9, s11};
	public Position[] sArrayStart = {s2, s4, s6, s8, s10};
	public int[] sObjectArray = {11374, 11378, 11375, 11376, 11377};
	public String[] sActionArray = {"Jump", "Cross", "Jump", "Jump", "Jump"};
	
	// Pollnivneach
	public Area pstart = new Area(3350, 2962, 3352, 2961);
	Position p1 = new Position(3351, 2964, 1);
	Position p2 = new Position(3350, 2968, 1);
	Position p3 = new Position(3352, 2973, 1);
	Position p4 = new Position(3355, 2976, 1);
	Position p5 = new Position(3360, 2977, 1);
	Position p6 = new Position(3362, 2977, 1);
	Position p7 = new Position(3366, 2976, 1);
	Position p8 = new Position(3368, 2976, 1);
	Position p9 = new Position(3368, 2982, 1);
	Position p10 = new Position(3365, 2982, 1);
	Position p11 = new Position(3365, 2983, 2);
	Position p12 = new Position(3358, 2984, 2);
	Position p13 = new Position(3358, 2991, 2);
	Position p14 = new Position(3359, 2995, 2);
	Position p15 = new Position(3359, 3000, 2);
	Position p16 = new Position(3362, 3002, 2);
	Position p17 = new Position(3363, 2998, 0);
	public Position[] pArrayEnd = {p1, p3, p5, p7, p9, p11, p13, p15, p17};
	public Position[] pArrayStart = {p2, p4, p6, p8, p10, p12, p14, p16};
	public int[] pObjectArray = {11381, 11382, 11383, 11384, 11385, 11386, 11389,
			11390, };
	public String[] pActionArray = {"Jump-on", "Grab", "Leap", "Jump-to", "Climb",
			"Cross", "Jump-on", "Jump-to", };
	
	// Relleka
	public Area rstart = new Area(2626, 3677, 2624, 3678);
	Position r1 = new Position(2625, 3676, 3);
	Position r2 = new Position(2622, 3672, 3);
	Position r3 = new Position(2622, 3668, 3);
	Position r4 = new Position(2622, 3658, 3);
	Position r5 = new Position(2627, 3654, 3);
	Position r6 = new Position(2629, 3655, 3);
	Position r7 = new Position(2639, 3653, 3);
	Position r8 = new Position(2642, 3653, 3);
	Position r9 = new Position(2643, 3657, 3);
	Position r10 = new Position(2647, 3662, 3);
	Position r11 = new Position(2655, 3670, 3);
	Position r12 = new Position(2655, 3674, 3);
	Position r13 = new Position(2652, 3676, 0);
	public Position[] rArrayEnd = {r1, r3, r5, r7, r9, r11, r13};
	public Position[] rArrayStart = {r2, r4, r6, r8, r10, r12};
	public int[] rObjectArray = {11392, 11393, 11395, 11396, 11397, 11404, };
	public String[] rActionArray = {"Leap", "Cross", "Leap", "Hurdle", "Cross", "Jump-in"
			};
	
	// Ardougne
	
	// FINAL
	public Area START, END;
	public Position[] ARRAYEND, ARRAYSTART;
	public String[] ARRAYACTION;
	public int[] ARRAYOBJECT;
	
	public void initializeCourse() {
		switch (course) {
		default:
			break;
		case "select": 
			
			break;
		case "draynor":
			START = dstart;
			ARRAYEND = Arrays.copyOf(dArrayEnd, dArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(dArrayStart, dArrayStart.length);
			ARRAYACTION = Arrays.copyOf(dActionArray, dActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(dObjectArray, dObjectArray.length);
			break;
		case "alkharid":
			START = astart;
			ARRAYEND = Arrays.copyOf(aArrayEnd, aArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(aArrayStart, aArrayStart.length);
			ARRAYACTION = Arrays.copyOf(aActionArray, aActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(aObjectArray, aObjectArray.length);
			break;
		case "varrock":
			START = vstart;
			ARRAYEND = Arrays.copyOf(vArrayEnd, vArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(vArrayStart, vArrayStart.length);
			ARRAYACTION = Arrays.copyOf(vActionArray, vActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(vObjectArray, vObjectArray.length);
			break;
		case "canifis":
			START = cstart;
			ARRAYEND = Arrays.copyOf(cArrayEnd, cArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(cArrayStart, cArrayStart.length);
			ARRAYACTION = Arrays.copyOf(cActionArray, cActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(cObjectArray, cObjectArray.length);
			break;
		case "falador":
			START = fstart;
			ARRAYEND = Arrays.copyOf(fArrayEnd, fArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(fArrayStart, fArrayStart.length);
			ARRAYACTION = Arrays.copyOf(fActionArray, fActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(fObjectArray, fObjectArray.length);
			break;
		case "seers":
			START = sstart;
			ARRAYEND = Arrays.copyOf(sArrayEnd, sArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(sArrayStart, sArrayStart.length);
			ARRAYACTION = Arrays.copyOf(sActionArray, sActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(sObjectArray, sObjectArray.length);
			break;
		case "pollnivneach":
			START = pstart;
			ARRAYEND = Arrays.copyOf(pArrayEnd, pArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(pArrayStart, pArrayStart.length);
			ARRAYACTION = Arrays.copyOf(pActionArray, pActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(pObjectArray, pObjectArray.length);
			break;
		case "rellekka":
			START = rstart;
			ARRAYEND = Arrays.copyOf(rArrayEnd, rArrayEnd.length);
			ARRAYSTART = Arrays.copyOf(rArrayStart, rArrayStart.length);
			ARRAYACTION = Arrays.copyOf(rActionArray, rActionArray.length);
			ARRAYOBJECT = Arrays.copyOf(rObjectArray, rObjectArray.length);
			break;
		case "ardougne":
			
			break;
		}
	}

	public int getfailsafe() {
		return failsafe;
	}

	public void incrementfailsafe() {
		failsafe++;		
	}

	public int getLapsBeforeBreak() {
		return lapsBeforeBreak;
	}

	public void setLapsBeforeBreak(int lapsBeforeBreak) {
		this.lapsBeforeBreak = lapsBeforeBreak;
	}
	
	public void reset() {
		failsafe = 0;		
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String s) {
		this.status = s;
	}

	public int getFailsaferu() {
		return failsaferu;
	}

	public void setFailsaferu(int failsaferu) {
		this.failsaferu = failsaferu;
	}

	public int getEnergyToDrinkAt() {
		return nrg;
	}
	
	public void setEnergy(int n) {
		this.nrg = n;
		if (this.nrg <= 0) {
			this.nrg = 65;
		}
	}

	public int getCameraX() {
		return cameraX;
	}

	public int getCameraY() {
		return cameraY;
	}

	public void setCamera(int i, int j) {
		this.cameraX = i;
		this.cameraY = j;
	}
}

