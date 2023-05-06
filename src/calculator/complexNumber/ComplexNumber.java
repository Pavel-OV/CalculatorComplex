package calculator.complexNumber;

public class ComplexNumber extends ComplexAdapter{
    private int index;
    private int realmuber;
    private int imaginaryunit;
    
    public ComplexNumber(int index, int realmuber, int imaginaryunit) {
        this.index = index;
        this.realmuber = realmuber;
        this.imaginaryunit = imaginaryunit;
    }

    public int getIndex() {
        return index;
    }

    public int getRealmuber() {
        return realmuber;
    }

    public int getImaginaryunit() {
        return imaginaryunit;
    }

    @Override
    public String toString() {
        if (imaginaryunit < -1) {
            return String.format("z%d=%d-%di", index, realmuber, -(imaginaryunit));
        }
        if (imaginaryunit == -1) {
            return String.format("z%d=%d-i", index, realmuber);
        }
        if (imaginaryunit == 1) {
            return String.format("z%d=%d+i", index, realmuber);
        }
        return String.format("z%d=%d+%di", index,realmuber, imaginaryunit);

    }
    @Override
    public ComplexNumber subtraction(Digits  arg2) {
        //z1- z2= (a1+b1i) - (a2+b1i) = (a1-a2) + (b1-b2)i
        ComplexNumber z1 = this;
        ComplexNumber z2 = (ComplexNumber) arg2;
        int nextA = z1.getRealmuber() - z2.getRealmuber();
        int nextB = z1.getImaginaryunit() - z2.getImaginaryunit();
        int maxInd = this.getIndex();
        if (z2.getIndex() > maxInd) maxInd = z2.getIndex();
        return new ComplexNumber(maxInd + 1, nextA, nextB);
    }

    @Override
    public ComplexNumber sum(Digits arg2) {
        //z1+z2= (a1+b1i) + (a2+b2i) = (a1+a2) + (b1+b2)i
        ComplexNumber z1 = this;
        ComplexNumber z2 = (ComplexNumber) arg2;
        int nextA = z1.getRealmuber() + z2.getRealmuber();
        int nextB = z1.getImaginaryunit() + z2.getImaginaryunit();
        int maxInd = this.getIndex();
        if (z2.getIndex() > maxInd) maxInd = z2.getIndex();
        return new ComplexNumber(maxInd + 1, nextA, nextB);
    }
    @Override
    public ComplexNumber multiplication(Digits arg2) {
    /*
    z1*z2= (a1+b1i)*(a2+b2i) = a1*a2 + a1*b2i + b1*a2i +(b1*b2)i^2 =
    = (a1*a2 - b1*b2) + (a1*b2 + a2*b1)i
     */
        ComplexNumber z1 = this;
        ComplexNumber z2 = (ComplexNumber) arg2;
        int nextA = (z1.getRealmuber() * z2.getRealmuber()) - (z1.getImaginaryunit() * z2.getImaginaryunit());
        int nextB = (z1.getRealmuber() * z2.getImaginaryunit()) + (z2.getRealmuber() * z1.getImaginaryunit());
        int maxInd = this.getIndex();
        if (z2.getIndex() > maxInd) maxInd = z2.getIndex();
        return new ComplexNumber(maxInd + 1, nextA, nextB);
    }


    
}
 