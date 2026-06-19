
# Uso de Mixin
---
### Ejemplo: BeeMixin (Serilum/RealisticBees)

    @Mixin(value = Bee.class, priority = 1001)
    public abstract class BeeMixin extends Animal {
        protected BeeMixin(EntityType<? extends Animal> p_27557_, Level p_27558_) {
            super(p_27557_, p_27558_);
        }

        @Inject(method = "<init>(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", at = @At(value = "TAIL"))
        public void Bee(EntityType<? extends Bee> beeEntityType, Level level, CallbackInfo ci) {
            Bee bee = (Bee)(Object)this;
            EntityFunctions.setEntitySize(bee, (EntityDimensions.scalable(0.7F, 0.6F)).scale((float)ConfigHandler.beeSizeModifier), bee.getEyeHeight(Pose.STANDING));
        }
    
        @Inject(method = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", at = @At(value = "HEAD"), cancellable = true)
        private void hurt(DamageSource damageSource, float amount, CallbackInfoReturnable<Boolean> cir) {
            Bee bee = (Bee)(Object)this;
            if (ConfigHandler.preventBeeSuffocationDamage && damageSource.equals(bee.level().damageSources().inWall())) {
                cir.setReturnValue(false);
            }
        }
    
        @Override
        public float getScale() {
            AttributeMap $$0 = this.getAttributes();
            return $$0 == null ? 1.0F : (float)ConfigHandler.beeSizeModifier;
        }
    }


### Explicación (Github-Claude Haiku 4.5)

Conceptos usados en **BeeMixin.java**

**1. @Mixin - Modificación de clases**
```
@Mixin(value = Bee.class, priority = 1001)
public abstract class BeeMixin extends Animal {
```
* `@Mixin`: Anotación que indica que esta clase modifica el comportamiento de **_Bee.class_**
* `priority` = 1001: Define el orden de ejecución cuando hay múltiples **_mixins_** (mayor prioridad = se ejecuta primero)
* Permite modificar clases sin acceso al código fuente original

---
**2. @Inject - Inyección de código**
```
@Inject(method = "...", at = @At(value = "TAIL"))
```
* `@Inject`: Inserta código personalizado en un método existente
* `method`: Especifica qué método modificar (usando descriptor de método de Java)
* `at = @At(value = "TAIL")`: Define DÓNDE inyectar (**_TAIL_** = al final)

---
**3. Descriptor de método (Firma de método)**
```
@Inject(method = "<init>(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", ...)
```
* `<init>`: Constructor 
* `L...;`: Tipos de parámetros (L = objeto, V = void)  
* **Formato**: `methodName(parameterTypes)returnType`
  * Ejemplo:  
          `<init>(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V` = Constructor con 2 parámetros que no retorna nada

---
**4. CallbackInfo - Control de ejecución**
```
public void Bee(EntityType<? extends Bee> beeEntityType, Level level, CallbackInfo ci) {
// ...
}
```
* `CallbackInfo`: Parámetro obligatorio en **_@Inject_** (proporciona acceso al contexto)
* Permite comunicarse con el método original
* Tipo: `CallbackInfo` (cuando no hay retorno) o `CallbackInfoReturnable<T>` (cuando hay retorno)

---
**5. CallbackInfoReturnable - Cancelar ejecución**
```
@Inject(method = "hurt(...)", at = @At(value = "HEAD"), cancellable = true)
private void hurt(DamageSource damageSource, float amount, CallbackInfoReturnable<Boolean> cir) {
    if (ConfigHandler.preventBeeSuffocationDamage && ...) {
    cir.setReturnValue(false);  // Cancela el método original
    }
}
```
* `CallbackInfoReturnable`: Versión especial que permite cambiar el valor retornado
* `cancellable = true`: Permite cancelar la ejecución del método original
* `cir.setReturnValue(false)`: Retorna **_false_** sin ejecutar el código original del método **_hurt_**

---
**6. Casting - Conversión de tipos**
```
Bee bee = (Bee)(Object)this;
```
* `(Bee)(Object)this`: Convierte **_this_** (que es un **_BeeMixin_**) a una instancia de **_Bee_**
* Necesario porque **_BeeMixin_** hereda de **_Animal_**, pero **_Mixin_** internamente trabaja con la clase original (**_Bee_**)
* El `(Object)` intermedio es una técnica de casting seguro

---
**7. @At(value = "HEAD") - Inyección al inicio**
```
at = @At(value = "HEAD")
```
* `HEAD`: nyecta en el inicio del método (antes de cualquier código)
* Usado para:
  * Validar parámetros 
  * Interceptar y cancelar operaciones 
  * Pre-procesamiento

**8. @At(value = "TAIL") - Inyección al final**
```
at = @At(value = "TAIL")
```
* `TAIL`: Inyecta al final del método (después de todo el código)
* Usado para:
  * Post-procesamiento
  * Modificar estado después de inicialización
  * Cleanup/limpieza  

---
**9. @Override - Reemplazar método**
```
@Override
public float getScale() {
return $$0 == null ? 1.0F : (float)ConfigHandler.beeSizeModifier;
}
```
* `@Override`: Reemplaza completamente la implementación original
* Diferencia con **_@Inject_**:
  * **@Inject** = modifica el método (ejecuta original + tu código)
  * **@Override** = reemplaza completamente el método

---
**10. Coerción de tipos (Ternario)**
```
return $$0 == null ? 1.0F : (float)ConfigHandler.beeSizeModifier;
```
* Operador ternario: _condición_ `?` _valor "Si"_ : _valor "No"_ (if: else)
* Si **_$$0_** (_AttributeMap_) es **_null_** → retorna **_1.0F_** (tamaño normal)
* Si no es **_null_** → retorna el modificador de tamaño configurado

---
**Flujo de ejecución completo**

    ┌─ CREACIÓN DE BEE
    │  ├─ Constructor Bee() original
    │  └─ [TAIL INJECT] → setEntitySize() → Modifica tamaño
    │
    ├─ CUANDO BEE RECIBE DAÑO
    │  ├─ [HEAD INJECT] → Verifica si es daño por asfixia
    │  │  ├─ Si es asfixia → cir.setReturnValue(false) → CANCELA el daño
    │  │  └─ Si no → continúa con hurt() original
    │
    └─ CONSULTAR ESCALA
    └─ getScale() → Retorna ConfigHandler.beeSizeModifier (OVERRIDE)


| Concepto      | Propósito                       |
|:--------------|:--------------------------------|
| @Mixin        | Modificar clase existente       |
| @Inject       | Insertar código en método       |
| HEAD/TAIL     | Dónde inyectar (inicio/fin)     |
| CallbackInfo	 | Interactuar con método original |
| cancellable	  | Permitir cancelar ejecución     |
| @Override	    | Reemplazar método completamente |
| Casting	      | Convertir tipos de datos        |
