package App;

public class User {
	    int id;
	    String name;
	    String email;
	    String password;
	    float humidity;
	    float temperature;
	    String time;
	    float meanh;
	    float medianh;
	    float modeh;
	    float varianceh;
	    float standivh;
	    float minh;
	    float maxh;
	    float meant;
	    float mediant;
	    float modet;
	    float variancet;
	    float standivt;
	    float mint;
	    float maxt;
	   
	    
		



		public User() {
	    }
		
		

		public User(int id,float humidity, float temperature, String time) {
			super();
			this.id=id;
			this.humidity = humidity;
			this.temperature = temperature;
			this.time = time;
		}


	    public User(int id, String name, String email, String password) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	    public User(String name, String email, String password) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	    public User(String name, String password) {
	        this.name = name;
	        this.password = password;
	    }
	    
	    public User(float humidity, float temperature) {
			super();
			this.humidity = humidity;
			this.temperature = temperature;
		}
	    
	    
		
	    

		public float getMeanh() {
			return meanh;
		}



		public void setMeanh(float meanh) {
			this.meanh = meanh;
		}



		public float getMedianh() {
			return medianh;
		}



		public void setMedianh(float medianh) {
			this.medianh = medianh;
		}



		public float getModeh() {
			return modeh;
		}



		public void setModeh(float modeh) {
			this.modeh = modeh;
		}



		public float getVarianceh() {
			return varianceh;
		}



		public void setVarianceh(float varianceh) {
			this.varianceh = varianceh;
		}



		public float getStandivh() {
			return standivh;
		}



		public void setStandivh(float standivh) {
			this.standivh = standivh;
		}



		public float getMinh() {
			return minh;
		}



		public void setMinh(float minh) {
			this.minh = minh;
		}



		public float getMaxh() {
			return maxh;
		}



		public void setMaxh(float maxh) {
			this.maxh = maxh;
		}



		public float getMeant() {
			return meant;
		}



		public void setMeant(float meant) {
			this.meant = meant;
		}



		public float getMediant() {
			return mediant;
		}



		public void setMediant(float mediant) {
			this.mediant = mediant;
		}



		public float getModet() {
			return modet;
		}



		public void setModet(float modet) {
			this.modet = modet;
		}



		public float getVariancet() {
			return variancet;
		}



		public void setVariancet(float variancet) {
			this.variancet = variancet;
		}



		public float getStandivt() {
			return standivt;
		}



		public void setStandivt(float standivt) {
			this.standivt = standivt;
		}



		public float getMint() {
			return mint;
		}



		public void setMint(float mint) {
			this.mint = mint;
		}



		public float getMaxt() {
			return maxt;
		}



		public void setMaxt(float maxt) {
			this.maxt = maxt;
		}



		public User(float meanh, float medianh, float modeh, float varianceh, float standivh, float minh, float maxh,
				float meant, float mediant, float modet, float variancet, float standivt, float mint, float maxt) {
			super();
			this.meanh = meanh;
			this.medianh = medianh;
			this.modeh = modeh;
			this.varianceh = varianceh;
			this.standivh = standivh;
			this.minh = minh;
			this.maxh = maxh;
			this.meant = meant;
			this.mediant = mediant;
			this.modet = modet;
			this.variancet = variancet;
			this.standivt = standivt;
			this.mint = mint;
			this.maxt = maxt;
		}



		public float getHumidity() {
			return humidity;
		}



		public void setHumidity(float humidity) {
			this.humidity = humidity;
		}



		public float getTemperature() {
			return temperature;
		}



		public void setTemperature(float temperature) {
			this.temperature = temperature;
		}



		public String getTime() {
			return time;
		}



		public void setTime(String time) {
			this.time = time;
		}

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password; 
	    }
	


	
}

