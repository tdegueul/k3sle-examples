/**
 */
package timedfsm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import timedfsm.FSM;
import timedfsm.State;
import timedfsm.TimedfsmPackage;
import timedfsm.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link timedfsm.impl.StateImpl#getOwningFSM <em>Owning FSM</em>}</li>
 *   <li>{@link timedfsm.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link timedfsm.impl.StateImpl#getOutgoingTransition <em>Outgoing Transition</em>}</li>
 *   <li>{@link timedfsm.impl.StateImpl#getIncomingTransition <em>Incoming Transition</em>}</li>
 *   <li>{@link timedfsm.impl.StateImpl#getWaitingTime <em>Waiting Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoingTransition() <em>Outgoing Transition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoingTransition;

	/**
	 * The cached value of the '{@link #getIncomingTransition() <em>Incoming Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incomingTransition;

	/**
	 * The default value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected static final int WAITING_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected int waitingTime = WAITING_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimedfsmPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSM getOwningFSM() {
		if (eContainerFeatureID() != TimedfsmPackage.STATE__OWNING_FSM) return null;
		return (FSM)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningFSM(FSM newOwningFSM, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningFSM, TimedfsmPackage.STATE__OWNING_FSM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningFSM(FSM newOwningFSM) {
		if (newOwningFSM != eInternalContainer() || (eContainerFeatureID() != TimedfsmPackage.STATE__OWNING_FSM && newOwningFSM != null)) {
			if (EcoreUtil.isAncestor(this, newOwningFSM))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningFSM != null)
				msgs = ((InternalEObject)newOwningFSM).eInverseAdd(this, TimedfsmPackage.FSM__OWNED_STATE, FSM.class, msgs);
			msgs = basicSetOwningFSM(newOwningFSM, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimedfsmPackage.STATE__OWNING_FSM, newOwningFSM, newOwningFSM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimedfsmPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoingTransition() {
		if (outgoingTransition == null) {
			outgoingTransition = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, TimedfsmPackage.STATE__OUTGOING_TRANSITION, TimedfsmPackage.TRANSITION__SOURCE);
		}
		return outgoingTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIncomingTransition() {
		if (incomingTransition == null) {
			incomingTransition = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, TimedfsmPackage.STATE__INCOMING_TRANSITION, TimedfsmPackage.TRANSITION__TARGET);
		}
		return incomingTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWaitingTime() {
		return waitingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaitingTime(int newWaitingTime) {
		int oldWaitingTime = waitingTime;
		waitingTime = newWaitingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimedfsmPackage.STATE__WAITING_TIME, oldWaitingTime, waitingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TimedfsmPackage.STATE__OWNING_FSM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningFSM((FSM)otherEnd, msgs);
			case TimedfsmPackage.STATE__OUTGOING_TRANSITION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransition()).basicAdd(otherEnd, msgs);
			case TimedfsmPackage.STATE__INCOMING_TRANSITION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransition()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TimedfsmPackage.STATE__OWNING_FSM:
				return basicSetOwningFSM(null, msgs);
			case TimedfsmPackage.STATE__OUTGOING_TRANSITION:
				return ((InternalEList<?>)getOutgoingTransition()).basicRemove(otherEnd, msgs);
			case TimedfsmPackage.STATE__INCOMING_TRANSITION:
				return ((InternalEList<?>)getIncomingTransition()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TimedfsmPackage.STATE__OWNING_FSM:
				return eInternalContainer().eInverseRemove(this, TimedfsmPackage.FSM__OWNED_STATE, FSM.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimedfsmPackage.STATE__OWNING_FSM:
				return getOwningFSM();
			case TimedfsmPackage.STATE__NAME:
				return getName();
			case TimedfsmPackage.STATE__OUTGOING_TRANSITION:
				return getOutgoingTransition();
			case TimedfsmPackage.STATE__INCOMING_TRANSITION:
				return getIncomingTransition();
			case TimedfsmPackage.STATE__WAITING_TIME:
				return getWaitingTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TimedfsmPackage.STATE__OWNING_FSM:
				setOwningFSM((FSM)newValue);
				return;
			case TimedfsmPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case TimedfsmPackage.STATE__OUTGOING_TRANSITION:
				getOutgoingTransition().clear();
				getOutgoingTransition().addAll((Collection<? extends Transition>)newValue);
				return;
			case TimedfsmPackage.STATE__INCOMING_TRANSITION:
				getIncomingTransition().clear();
				getIncomingTransition().addAll((Collection<? extends Transition>)newValue);
				return;
			case TimedfsmPackage.STATE__WAITING_TIME:
				setWaitingTime((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TimedfsmPackage.STATE__OWNING_FSM:
				setOwningFSM((FSM)null);
				return;
			case TimedfsmPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TimedfsmPackage.STATE__OUTGOING_TRANSITION:
				getOutgoingTransition().clear();
				return;
			case TimedfsmPackage.STATE__INCOMING_TRANSITION:
				getIncomingTransition().clear();
				return;
			case TimedfsmPackage.STATE__WAITING_TIME:
				setWaitingTime(WAITING_TIME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TimedfsmPackage.STATE__OWNING_FSM:
				return getOwningFSM() != null;
			case TimedfsmPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TimedfsmPackage.STATE__OUTGOING_TRANSITION:
				return outgoingTransition != null && !outgoingTransition.isEmpty();
			case TimedfsmPackage.STATE__INCOMING_TRANSITION:
				return incomingTransition != null && !incomingTransition.isEmpty();
			case TimedfsmPackage.STATE__WAITING_TIME:
				return waitingTime != WAITING_TIME_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", waitingTime: ");
		result.append(waitingTime);
		result.append(')');
		return result.toString();
	}

} //StateImpl
