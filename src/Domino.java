public class Domino {
    private int top;
    private int bottom;

    public Domino(){
        this.top=0;
        this.bottom=0;
    }

    public Domino(int top,int bottom){
        this.top=top;
        this.bottom=bottom;
    }

    public int getTop(){
        return top;
    }

    public int getBottom(){
        return bottom;
    }

    public void setTop(int top){
        this.top=top;
    }

    public void setBottom(int bottom){
        this.bottom=bottom;
    }

    public String toString(){
        return top+"/"+bottom;
    }

    public void flip(){
        int temp=top;
        top=bottom;
        bottom=temp;
    }

    public void settle(){
        if(bottom<top){
            this.flip();
        }
    }

    public int compareTo(Domino other){
        this.settle();
        other.settle();
        if(this.getTop()<other.getTop()){
            return -1;
        }
        else if(this.getTop()>other.getTop()){
            return 1;
        }
        else if(this.getTop()==other.getTop()){
            if(this.getBottom()<other.getBottom()){
                return -1;
            }
            else if(this.getBottom()>other.getBottom()){
                return 1;
            }

        }
        return 0;
    }

    public int compareToWeight(Domino other){
        int thisWeight=top+bottom;
        int otherWeight=other.getTop()+other.getBottom();

        if(thisWeight<otherWeight){
            return -1;
        }
        else if(thisWeight>otherWeight){
            return 1;
        }
        else{
            return 0;
        }
    }

    public boolean canConnect(Domino other){
        return ((this.top==other.getTop())||(this.top==other.getBottom())||(this.bottom==other.getTop())||(this.bottom==other.getBottom()));
    }
}