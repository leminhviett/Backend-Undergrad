package snippet

// Behavioural pattern: to seperate algorithm from real concrete Object

type visitor interface {
	algoVisitA(a *A)
	algoVisitB(b *B)
}

type element interface { //client of the visitor
	accept(v visitor)
}

type A struct{}

func (a *A) accept(v visitor) {
	// to redirect to the correct concrete implementation
	v.algoVisitA(a)
}

type B struct{}

func (b *B) accept(v visitor) {
	// to redirect to the correct concrete implementation
	v.algoVisitB(b)
}

type concretVisitor struct{}

func (v *concretVisitor) algoVisitA(a *A) {}
func (v *concretVisitor) algoVisitB(b *B) {}

func main() {
	a := &A{}
	b := &B{}

	v := &concretVisitor{}

	a.accept(v)
	b.accept(v)

	//other possible usage. Client can use visitor to directly call expected func
	v.algoVisitA(a)
	v.algoVisitB(b)
}
