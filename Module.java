public class Module{
    String moduleCode;
    String moduleName;
    int semester;
    int credits;

    public Module(String moduleCode, String moduleName, int semester, int credits){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.semester = semester;
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public int getSemester() {
        return semester;
    }

    /**
     * for test
     * @return
     */
    @Override
    public String toString() {
        return "Module{" +
                "moduleCode='" + moduleCode + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", semester=" + semester +
                ", credits=" + credits +
                '}'+ '\n';
    }
}
