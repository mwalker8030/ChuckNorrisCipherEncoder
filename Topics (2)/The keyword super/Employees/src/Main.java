class Employee {

    // write fields
    protected String name, email;
    protected int experience;

    // write constructor
    public Employee(String n, String e, int ex){
        this.name = n;
        this.email = e;
        this.experience = ex;
    }

    // write getters
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public int getExperience(){
        return experience;
    }
}

class Developer extends Employee {

    // write fields
    String mainLanguage;
    String[] skills;

    // write constructor
    public Developer(String n, String e, int ex, String m, String[] s){
        super(n, e, ex);
        this.mainLanguage = m;
        this.skills = s;
    }

    // write getters
    public String getMainLanguage(){
        return mainLanguage;
    }

    public String[] getSkills(){
        return skills;
    }
}

class DataAnalyst extends Employee {

    // write fields
    boolean phd;
    String[] methods;


    // write constructor
    public DataAnalyst(String n, String e, int ex, boolean p, String[] m){
        super(n, e, ex);
        this.phd = p;
        this.methods = m;
    }

    // write getters
    public boolean isPhd(){
        return phd;
    }

    public String[] getMethods(){
        return methods;
    }
}