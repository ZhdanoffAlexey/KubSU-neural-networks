import net.sourceforge.jFuzzyLogic.FIS;

/**
 * Тестовый парсер FCL-файла
 * компилируем командой "javac -cp ./jFuzzyLogic_v2.1a.jar Student.java"
 * далее кладем файл student.class в каталог student
 * и запускаем командой "java -cp ./jFuzzyLogic_v2.1a.jar:Student Student" (Unix)
 * или "java -cp ./jFuzzyLogic_v2.1a.jar;student student" (Windows)
 */
public class Student {
	
	public static void main(String[] args) throws Exception {
		
		FIS fuzzyInferenceSystem = FIS.load("student.fcl", true);
		
		if (fuzzyInferenceSystem == null) { 
			System.err.println("Error loading file with name 'student.fcl'");
			return;
		}

		// Показываем.
		fuzzyInferenceSystem.chart();

		// Задаем значения входных переменных.
		fuzzyInferenceSystem.setVariable("sleepTime", 4);
		fuzzyInferenceSystem.setVariable("performance", 5);
		fuzzyInferenceSystem.setVariable("luck", 80);
		fuzzyInferenceSystem.setVariable("purpose", 50);

		// Вычисляем.
		fuzzyInferenceSystem.evaluate();

		// Печатаем информацию о выходной перменной.
		System.out.println(fuzzyInferenceSystem.getVariable("grade").toString());
		System.out.println(fuzzyInferenceSystem.getVariable("knowledge").toString());

		// Печатаем вещественное значение последней дефаззификации выходной переменной.
		System.out.println(fuzzyInferenceSystem.getVariable("grade").getValue());
		System.out.println(fuzzyInferenceSystem.getVariable("knowledge").getValue());

		// Показываем график выходной переменной. 
		fuzzyInferenceSystem.getVariable("grade").chartDefuzzifier(true);
		fuzzyInferenceSystem.getVariable("knowledge").chartDefuzzifier(true);

		// Печатаем набор правил.
		System.out.println(fuzzyInferenceSystem);
		
	}
	
}